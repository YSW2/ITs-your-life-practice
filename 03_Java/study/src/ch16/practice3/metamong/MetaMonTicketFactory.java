package ch16.practice3.metamong;

import ch16.practice3.framework.Ticket;
import ch16.practice3.framework.TicketFactory;

public class MetaMonTicketFactory extends TicketFactory {


    @Override
    protected Ticket createTicket (String owner) {
        return new MetaMonTicket(owner);
    }

    @Override
    protected void registerTicket (Ticket ticket) {
        System.out.println("티켓" + ticket + "등록 완료");
    }
}
