package org.example;

import java.util.Random;

public class AuctionRunner {
    public static void main(String[] args) {
        Auction auction = new Auction();

        int startPrice = new Random().nextInt(100);

        // Change (auction.BIDS_COUNT) on your
        for (int i = 0; i < auction.BIDS_COUNT; i++) {
            Bid thread = new Bid(i, startPrice, auction.getBarrier());

            auction.add(thread);
            thread.start();
        }
    }
}
