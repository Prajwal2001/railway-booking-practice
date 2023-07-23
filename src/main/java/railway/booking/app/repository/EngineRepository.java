package railway.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import railway.booking.app.entities.Engine;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Integer> {

}
