package railway.booking.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import railway.booking.app.entities.AppUser;

@NoRepositoryBean
public interface BaseRepository<M, N extends Serializable> extends JpaRepository<M, N> {
    List<M> findAllByDeleteFl(Boolean deleteFl);

    List<M> findAllByCreatedUser(AppUser createdUser);
}
