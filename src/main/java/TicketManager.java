public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket item) {
        repo.save(item);
    }

    public Ticket[] searchBy(String textFrom, String textTo) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getItems()) {
            if (matches(ticket, textFrom, textTo)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Ticket ticket, String searchFrom, String searchTo) {
        if (ticket.getFrom().contains(searchFrom) & ticket.getTo().contains(searchTo)) {
            return true;
        } else {
            return false;
        }
    }
}
