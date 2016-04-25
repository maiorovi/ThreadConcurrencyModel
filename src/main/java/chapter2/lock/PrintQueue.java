package chapter2.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

    private final Lock lock = new ReentrantLock();

    public void printJob(Object document) {
        lock.lock();
        try {
            Long duration=(long)(Math.random()*10000);
            System.out.println(Thread.currentThread().getName()+ ": PrintQueue: Printing a Job during "+(duration/1000)+
                    " seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
