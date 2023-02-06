public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket item) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = item;
        tickets = tmp;
    }

    public void removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        if (findById(id) != null) {
            for (Ticket item : tickets) {
                if (item.getId() != id) {
                    tmp[copyToIndex] = item;
                    copyToIndex++;
                }
            }
        } else {
            throw new NotFoundException(
                    "Билет с id: \" + id + \" не найден"
            );
        }
        tickets = tmp;
    }

    public Ticket findById(int id) {
        for (Ticket item : tickets) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Ticket[] getAllTickets() {
        Ticket[] all = getItems();
        return all;
    }

    public Ticket[] getItems() {
        return tickets;
    }
}

