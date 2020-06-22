package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CyclicBarrier;

public class Auction {

    private ArrayList<Bid> bids;
    private CyclicBarrier barrier;
    public final int BIDS_COUNT = 5;

    public Auction() {
        this.bids = new ArrayList<Bid>();
        this.barrier = new CyclicBarrier
                (this.BIDS_COUNT, new Runnable() {
                    @Override
                    public void run() {

                    }
                });
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public boolean add(Bid e) {
        return bids.add(e);
    }

    public Bid defineWinner() {
        return Collections.max(bids, new Comparator<Bid>() {
            @Override
            public int compare(Bid o1, Bid o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }
}
