package me.erdong.thkij.concurrency;

import java.util.concurrent.TimeUnit;

public class LiftOff implements Runnable {
    protected int countDown = 10; // Default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread.yield();
        }
    }
}
