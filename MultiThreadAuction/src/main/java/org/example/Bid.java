package org.example;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Bid extends Thread {

    private Integer bidId;
    private int price;
    private CyclicBarrier barrier;

    public Bid(int id, int price, CyclicBarrier barrier) {
        this.bidId = id;
        this.price = price;
        this.barrier = barrier;
    }

    public Integer getBidId() {
        return bidId;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public void run() {
        try {
            System.out.println("Клиент " + this.bidId + " определил цену.");

            Thread.sleep(new Random().nextInt(3000));
            int delta = new Random().nextInt(50);
            price += delta;
            System.out.println("Ставка " + this.bidId + " : " + price);
            this.barrier.await();
            System.out.println("Подождите...");

        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
