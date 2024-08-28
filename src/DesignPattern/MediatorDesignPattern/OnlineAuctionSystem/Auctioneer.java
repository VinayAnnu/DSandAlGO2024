package DesignPattern.MediatorDesignPattern.OnlineAuctionSystem;

import java.util.ArrayList;
import java.util.List;

public class Auctioneer implements AuctionMediator {
    private List<Bidder> bidders;
    private Bidder highestBidder;
    private double highestBid;

    public Auctioneer() {
        this.bidders = new ArrayList<>();
        this.highestBid = 0.0;
    }

    @Override
    public void addBidder(Bidder bidder) {
        this.bidders.add(bidder);
    }

    @Override
    public void placeBid(Bidder bidder, double bidAmount) {
        if (bidAmount > highestBid) {
            highestBid = bidAmount;
            highestBidder = bidder;
            System.out.println(bidder.getName() + " placed the highest bid of $" + bidAmount);
        } else {
            System.out.println(bidder.getName() + " placed a bid of $" + bidAmount + " but it was too low.");
        }
    }

    @Override
    public void announceWinner() {
        if (highestBidder != null) {
            System.out.println("The winner is " + highestBidder.getName() + " with a bid of $" + highestBid);
        } else {
            System.out.println("No bids were placed.");
        }
    }
}
