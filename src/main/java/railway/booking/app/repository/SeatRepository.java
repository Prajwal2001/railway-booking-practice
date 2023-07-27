package railway.booking.app.repository;

import org.springframework.stereotype.Repository;

import railway.booking.app.entities.Seat;

@Repository
public interface SeatRepository extends BaseRepository<Seat, Long> {

}
