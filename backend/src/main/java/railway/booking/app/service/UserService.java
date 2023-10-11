package railway.booking.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import railway.booking.app.entities.AppUser;
import railway.booking.app.enums.UserEnums;
import railway.booking.app.repository.AppUserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user = null;
        if (appUserRepository.findByEmailId(email).isPresent()) {
            user = appUserRepository.findByEmailId(email).get();
        } else {
            throw new UsernameNotFoundException(String.format(UserEnums.INVALID_USER.getValue(), email));
        }
        return user;
    }
}
