package railway.booking.app.service;

import java.time.Instant;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import railway.booking.app.entities.AppUser;
import railway.booking.app.enums.GeneralEnums;
import railway.booking.app.enums.JWTEnums;
import railway.booking.app.repository.AppUserRepository;

@Service
public class TokenService {

    @Autowired
    private JwtEncoder jwtEncoder;

    @Autowired
    private AppUserRepository appUserRepository;

    @Value("${jwt.expiry.seconds}")
    private Long jwtExpirationSeconds;

    public String generateJwt(Authentication auth) {
        Instant now = Instant.now();
        String scope = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(GeneralEnums.WHITE_SPACE.getStringValue1()));

        AppUser appUser = appUserRepository.findByEmailId(auth.getName()).get();

        Consumer<Map<String, Object>> claims = a -> {
            a.put(JWTEnums.ROLES_CLAIM.getValue() , scope);
            a.put(JWTEnums.USER_CLAIM.getValue(), appUser.getName());
        };

        JwtClaimsSet jwtClaims = JwtClaimsSet.builder()
                .issuer(JWTEnums.ISSUER.getValue())
                .issuedAt(now)
                .subject(auth.getName())
                .claims(claims)
                .expiresAt(now.plusSeconds(jwtExpirationSeconds))
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(jwtClaims)).getTokenValue();
    }

}
