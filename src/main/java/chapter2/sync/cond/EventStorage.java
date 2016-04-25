package chapter2.sync.cond;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {
    private int maxSize;
    private LinkedList<Date> storage;

    public  EventStorage() {
        storage = new LinkedList<>();
        maxSize = 10;
    }

    public synchronized void get() {
      while(storage.size() == 0) {
          try {
              wait();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
        System.out.printf("Get: %d: %s \n",storage.size(),storage.poll());
        notifyAll();
    }

    public synchronized void set() {
        while(storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        storage.offer(new Date());
        System.out.printf("Set: %d \n",storage.size());
        notifyAll();
    }

}
