package DesignPattern.MediatorDesignPattern.OnlineAuctionSystem;

public interface AuctionMediator {
    void addBidder(Bidder bidder);
    void placeBid(Bidder bidder, double bidAmount);
    void announceWinner();
}
