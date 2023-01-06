package me.erdong.thkij.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimplePrioritie implements Runnable {
    private int countDown = 5;
    private volatile double d; // No optimization
    private int priority;

    public SimplePrioritie(int priority) {
        this.priority = priority;
    }

    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            // An expensive, interruptable operation:
            for (int i = 1; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new SimplePrioritie(Thread.MIN_PRIORITY));
        exec.execute(new SimplePrioritie(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
