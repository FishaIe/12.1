import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketRepositoryTest {

    Ticket item1 = new Ticket(1, 300, "KEJ", "LED", 300);
    Ticket item2 = new Ticket(2, 200, "ROV", "DME", 100);
    Ticket item3 = new Ticket(3, 100, "AAQ", "VKO", 200);

    @Test
    public void removeByIdTest() {

        TicketRepository repo = new TicketRepository();

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.removeById(item2.getId());

        Ticket[] expected = {item1, item3};
        Ticket[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeByIdErrorTest() {

        TicketRepository repo = new TicketRepository();

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(32);
        });
    }
}
