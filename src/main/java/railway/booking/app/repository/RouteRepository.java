package railway.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import railway.booking.app.entities.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

}
