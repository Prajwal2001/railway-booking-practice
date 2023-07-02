package railway.booking.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@EntityScan("railway.booking.entities")
@ComponentScan(basePackages = "railway.booking.*")
@OpenAPIDefinition(info = @Info(title = "Railway Booking System", license = @License(name = "railway.booking"), version = "1.0", description = "A simple railway booking app"))
@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
