package railway.booking.app.repository;

import org.springframework.stereotype.Repository;

import railway.booking.app.entities.Train;

@Repository
public interface TrainRepository extends BaseRepository<Train, Long> {

}
