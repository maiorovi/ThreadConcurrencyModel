package chapter2.sync.cond;

public class Demo {

    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();
        Consumer consumer = new Consumer(eventStorage);
        Producer producer = new Producer(eventStorage);

        Thread thread1 = new Thread(consumer);
        Thread thread2 = new Thread(producer);

        thread1.start();
        thread2.start();
    }
}
