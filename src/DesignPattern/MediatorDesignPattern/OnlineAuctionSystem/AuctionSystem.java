package DesignPattern.MediatorDesignPattern.OnlineAuctionSystem;

public class AuctionSystem {
    public static void main(String[] args) {
        AuctionMediator auctioneer = new Auctioneer();

        Bidder bidder1 = new AuctionBidder(auctioneer, "Alice");
        Bidder bidder2 = new AuctionBidder(auctioneer, "Bob");
        Bidder bidder3 = new AuctionBidder(auctioneer, "Charlie");

        auctioneer.addBidder(bidder1);
        auctioneer.addBidder(bidder2);
        auctioneer.addBidder(bidder3);

        bidder1.bid(100);
        bidder2.bid(150);
        bidder3.bid(120);
        bidder2.bid(200);

        auctioneer.announceWinner();
    }
}
