package railway.booking.app.repository;

import org.springframework.stereotype.Repository;

import railway.booking.app.entities.Passenger;

@Repository
public interface PassengerRepository extends BaseRepository<Passenger, Long> {

}
