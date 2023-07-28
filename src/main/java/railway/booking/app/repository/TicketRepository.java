package railway.booking.app.repository;

import org.springframework.stereotype.Repository;

import railway.booking.app.entities.Ticket;

@Repository
public interface TicketRepository extends BaseRepository<Ticket, Long> {

}
