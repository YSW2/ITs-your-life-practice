package ch14.sec01.practice02;

public class Fan implements Runnable {
    private String name;
    private boolean isVIP;
    private EntryManager entryManager;
    private TicketBuyer buyer;

    public Fan (String name, boolean isVIP, EntryManager entryManager, TicketBuyer buyer) {
        this.isVIP = isVIP;
        this.name = name;
        this.entryManager = entryManager;
        this.buyer = buyer;
    }

    public String getName() {
        return name;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public TicketBuyer getBuyer () {
        return buyer;
    }

    @Override
    public void run () {
        entryManager.registerFan(this);
        while (!entryManager.processEntry(this)) {
            try {
                buyer.waitTurn();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
