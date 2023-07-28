package railway.booking.app.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import railway.booking.app.entities.AppUser;
import railway.booking.app.entities.BaseEntity;

@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity, ID extends Serializable> extends JpaRepository<E, ID> {
    List<E> findAllByDeleteFl(Boolean deleteFl);

    List<E> findAllByCreatedUser(AppUser createdUser);
}
