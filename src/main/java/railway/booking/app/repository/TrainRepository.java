package railway.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import railway.booking.app.entities.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

}
