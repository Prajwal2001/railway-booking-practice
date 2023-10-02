package railway.booking.app.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import railway.booking.app.entities.Role;

@Repository
public interface RoleRepository extends BaseRepository<Role, Long> {
    Optional<Role> findByAuthority(String authority);
}
