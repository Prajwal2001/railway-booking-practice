package railway.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import railway.booking.app.entities.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

}
