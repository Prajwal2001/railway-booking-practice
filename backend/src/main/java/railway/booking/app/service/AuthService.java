package railway.booking.app.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import railway.booking.app.entities.AppUser;
import railway.booking.app.entities.Role;
import railway.booking.app.enums.UserEnums;
import railway.booking.app.exception.CustomException;
import railway.booking.app.models.LoginResponseModel;
import railway.booking.app.repository.AppUserRepository;
import railway.booking.app.repository.RoleRepository;

@Service
@Transactional
public class AuthService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public AppUser registerUser(String email, String userName, String password, String phNo) throws CustomException {
        AppUser newUser;

        Boolean isDuplicateEmail = appUserRepository.findByEmailId(email).isPresent();
        Boolean isDuplicatePhNo = appUserRepository.findByPhNo(phNo).isPresent();

        if (isDuplicateEmail && isDuplicatePhNo) {
            throw new CustomException(String.format(UserEnums.DUPLICATE_EMAIL_PHONE.getValue(), email, phNo));
        }
        if (isDuplicateEmail) {
            throw new CustomException(String.format(UserEnums.DUPLICATE_EMAIL.getValue(), email));
        }
        if (isDuplicatePhNo) {
            throw new CustomException(String.format(UserEnums.DUPLICATE_PHNO.getValue(), phNo));
        }

        String encodedPassword = passwordEncoder.encode(password);

        Role role = roleRepository.findByAuthority(UserEnums.USER_ROLE.getValue()).get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        newUser = new AppUser(0L, userName, email, phNo, encodedPassword, roles);

        try {
            return appUserRepository.save(newUser);
        } catch (DataAccessException e) {
            throw new CustomException(e.getMessage());
        }
    }

    public LoginResponseModel loginUser(String email, String password) throws CustomException {
        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(email, password);
            Authentication auth = authenticationManager.authenticate(authToken);
            String token = tokenService.generateJwt(auth);

            return new LoginResponseModel(appUserRepository.findByEmailId(email).get(), token);
        } catch (AuthenticationException e) {
            if (e instanceof BadCredentialsException) {
                if (appUserRepository.findByEmailId(email).isPresent()) {
                    throw new CustomException(UserEnums.INVALID_PASSWORD.getValue());
                }
                throw new CustomException(String.format(UserEnums.INVALID_USER.getValue(), email));
            }
            throw new CustomException(e.getMessage());
        }
    }
}
