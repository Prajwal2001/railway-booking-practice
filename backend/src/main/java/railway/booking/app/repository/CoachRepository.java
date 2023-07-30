package railway.booking.app.repository;

import org.springframework.stereotype.Repository;

import railway.booking.app.entities.Coach;

@Repository
public interface CoachRepository extends BaseRepository<Coach, Long> {

}
