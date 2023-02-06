import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketManagerTest {

    Ticket item1 = new Ticket(1, 300, "KEJ", "LED", 300);
    Ticket item2 = new Ticket(2, 200, "ROV", "DME", 100);
    Ticket item3 = new Ticket(3, 100, "AAQ", "VKO", 200);
    Ticket item4 = new Ticket(4, 250, "ROV", "DME", 100);
    Ticket item5 = new Ticket(5, 200, "ROV", "DME", 150);

    @Test
    public void managerAddTest() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);


        Ticket[] expected = {item1, item2, item3, item4};
        Ticket[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void managerSearchByTest() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        Ticket[] expected = {item1};
        Ticket[] actual = manager.searchBy("KEJ","LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void managerSearchByWith2ItemsTest() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        Ticket[] expected = {item2, item4};
        Ticket[] actual = manager.searchBy("ROV","DME");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void managerSearchByWithNoToTest() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("DME","SMTH");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void positiveCompereTest() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);

        Ticket[] expected = {item3, item2, item5, item4, item1};
        Ticket[] actual;
        Arrays.sort(repo.getItems());
    }
}
