package me.erdong.thkij.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {
    private final ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public void timed() {
        boolean captured;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " +
                    captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final AttemptLocking al = new AttemptLocking();
        al.untimed(); // True -- lock is available
        al.timed(); // True -- lock is available
        // Now create a separate task to grab the lock:
        new Thread() {
            {
                setDaemon(true); // 使用代码块充当构造器
            }

            public void run() {
                al.lock.lock();
                System.out.println("new thread acquired");
            }
        }.start();
        // Thread.yield(); // Give the 2nd task a chance
        TimeUnit.SECONDS.sleep(1);
        al.untimed(); // False -- lock grabbed by task
        al.timed(); // False -- lock grabbed by task
    }
}
