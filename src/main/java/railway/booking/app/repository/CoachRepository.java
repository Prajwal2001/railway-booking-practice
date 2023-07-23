package railway.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import railway.booking.app.entities.Coach;

public interface CoachRepository extends JpaRepository<Coach, Integer> {

}
