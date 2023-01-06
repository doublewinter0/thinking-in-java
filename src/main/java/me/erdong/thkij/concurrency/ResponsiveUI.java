package me.erdong.thkij.concurrency;

class UnresponsiveUI {
    private volatile double d = 1;

    public UnresponsiveUI() throws Exception {
        while (d > 0)
            d = d + (Math.PI + Math.E) / d;
        int i = System.in.read(); // Never gets here
        System.out.println("i = " + i);
    }
}

public class ResponsiveUI extends Thread {
    private static volatile double d = 1;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws Exception {
        // new UnresponsiveUI(); // Must kill this process
        new ResponsiveUI();
        int i = System.in.read();
        System.out.println("i = " + i);
        System.out.println(d); // Shows progress
    }
}
