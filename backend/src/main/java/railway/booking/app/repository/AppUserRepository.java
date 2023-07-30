package railway.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import railway.booking.app.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

}
