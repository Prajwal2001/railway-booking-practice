package railway.booking.app;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import railway.booking.app.entities.AppUser;
import railway.booking.app.entities.Role;
import railway.booking.app.enums.GeneralEnums;
import railway.booking.app.repository.AppUserRepository;
import railway.booking.app.repository.RoleRepository;

@OpenAPIDefinition(info = @Info(title = "Railway Booking System", license = @License(name = "railway.booking"), version = "1.0", description = "A simple railway booking app"))
@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	CommandLineRunner run( RoleRepository roleRepository, AppUserRepository appUserRepository, PasswordEncoder passwordEncoder ) {
		return args -> {
			if (roleRepository.findByAuthority(GeneralEnums.ADMIN.getStringValue1()).isPresent()) return;

			Role adminRole = roleRepository.save(new Role(1L, GeneralEnums.ADMIN.getStringValue1(), Boolean.FALSE));
			roleRepository.save(new Role(2L, GeneralEnums.USER.getStringValue1(), Boolean.FALSE));

			Set<Role> rolesSet = new HashSet<>();
			rolesSet.add(adminRole);

			AppUser admin = new AppUser(1L, "admin", "admin@admin.com", "1234567890", passwordEncoder.encode("password"), rolesSet);
			appUserRepository.save(admin);
		};
	}

}
