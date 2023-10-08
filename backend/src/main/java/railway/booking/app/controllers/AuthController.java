package railway.booking.app.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import railway.booking.app.entities.AppUser;
import railway.booking.app.exception.CustomException;
import railway.booking.app.logger.Log;
import railway.booking.app.models.LoginModel;
import railway.booking.app.models.LoginResponseModel;
import railway.booking.app.models.RegistrationModel;
import railway.booking.app.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private Log log;

    @PostMapping("/register")
    public ResponseEntity<AppUser> registerUser( @RequestBody RegistrationModel body ) {
        ResponseEntity<AppUser> responseEntity;
        
        AppUser user = null;
        try {
            user = authService.registerUser(body.getEmail(), body.getUserName(), body.getPassword(), body.getPhNo() );
            responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        } catch (CustomException e) {
            log.error(e.getMessage());
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.FORBIDDEN);
        }
        
        
        return responseEntity;
    }


    @PostMapping("/login")
    public LoginResponseModel loginUser(@RequestBody LoginModel loginModel) {
        return authService.loginUser(loginModel.getEmail(), loginModel.getPassword());
    }
}
