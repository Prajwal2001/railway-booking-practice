package railway.booking.app.service;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import railway.booking.app.entities.AppUser;
import railway.booking.app.entities.Role;
import railway.booking.app.enums.GeneralEnums;
import railway.booking.app.enums.UserEnums;
import railway.booking.app.exception.CustomException;
import railway.booking.app.logger.Log;
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

    @Autowired
    private Log log;

    public AppUser registerUser(String email, String userName, String password, String phNo) throws CustomException {
        AppUser newUser;

        Boolean isDuplicateEmail = appUserRepository.findByEmailId(email).isPresent();
        Boolean isDuplicatePhNo = appUserRepository.findByPhNo(phNo).isPresent();

        if (isDuplicateEmail && isDuplicatePhNo) {
            throw new CustomException(String.format(UserEnums.DUPLICATE_EMAIL_PHONE.getMessage(), email, phNo));
        }
        if (isDuplicateEmail) {
            throw new CustomException(String.format(UserEnums.DUPLICATE_EMAIL.getMessage(), email));
        }
        if (isDuplicatePhNo) {
            throw new CustomException(String.format(UserEnums.DUPLICATE_PHNO.getMessage(), phNo));
        }

        String encodedPassword = passwordEncoder.encode(password);
        Role role = roleRepository.findByAuthority(GeneralEnums.USER.getStringValue1()).get();

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        newUser = new AppUser(0L, userName, email, phNo, encodedPassword, roles);

        try {
            appUserRepository.save(newUser);
        } catch (DataAccessException e) {
            throw new CustomException(e.getMessage());
        }

        return newUser;
    }

    public LoginResponseModel loginUser(String email, String password) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password));
            String token = tokenService.generateJwt(auth);

            return new LoginResponseModel(appUserRepository.findByEmailId(email).get(), token);
        } catch (AuthenticationException e) {
            return new LoginResponseModel(null, "");
        }
    }
}
