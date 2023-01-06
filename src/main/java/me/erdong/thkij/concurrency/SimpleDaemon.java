package me.erdong.thkij.concurrency;

import java.util.concurrent.TimeUnit;

public class SimpleDaemon implements Runnable {
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println((Thread.currentThread() + " " + this));
            }
        } catch (InterruptedException e) {
            System.out.println(("sleep() interrupted"));
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemon());
            daemon.setDaemon(true); // Must call before start()
            daemon.start();
        }
        System.out.println(("All daemons started"));
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}
