package railway.booking.app.repository;

import org.springframework.stereotype.Repository;

import railway.booking.app.entities.Route;

@Repository
public interface RouteRepository extends BaseRepository<Route, Long> {

}
