package DesignPattern.MediatorDesignPattern.OnlineAuctionSystem;

public abstract class Bidder {
    protected AuctionMediator mediator;
    protected String name;

    public Bidder(AuctionMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void bid(double amount);

    public String getName() {
        return name;
    }
}
