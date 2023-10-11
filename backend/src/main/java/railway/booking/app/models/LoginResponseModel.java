package railway.booking.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import railway.booking.app.entities.AppUser;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseModel {
    private AppUser user;
    private String jwt;
}
