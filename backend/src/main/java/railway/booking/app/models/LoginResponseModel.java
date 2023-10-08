package railway.booking.app.models;

import lombok.Getter;
import lombok.Setter;
import railway.booking.app.entities.AppUser;

@Getter
@Setter
public class LoginResponseModel {
    
    private AppUser user;
    private String jwt;

    
    public LoginResponseModel(AppUser user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }
}
