package DesignPattern.MediatorDesignPattern.OnlineAuctionSystem;

public class AuctionBidder extends Bidder {
    public AuctionBidder(AuctionMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void bid(double amount) {
        System.out.println(this.name + " is placing a bid of $" + amount);
        mediator.placeBid(this, amount);
    }
}
