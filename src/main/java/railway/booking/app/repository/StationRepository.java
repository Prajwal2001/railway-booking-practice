package railway.booking.app.repository;

import org.springframework.stereotype.Repository;

import railway.booking.app.entities.Station;

@Repository
public interface StationRepository extends BaseRepository<Station, Long> {

}
