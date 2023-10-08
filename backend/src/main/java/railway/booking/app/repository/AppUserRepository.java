package railway.booking.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import railway.booking.app.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmailId(String emailId);
    Optional<AppUser> findByPhNo(String phNo);
}
