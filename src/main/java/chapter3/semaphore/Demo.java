package chapter3.semaphore;

public class Demo {

    public static void main(String[] args) {
        PrintingQueue printingQueue = new PrintingQueue();
        Thread[] thread = new Thread[10];

        for (int i =0; i < 10; i++) {
            thread[i] = new Thread(new Job(printingQueue), "Thread"+i);
        }

        for (int i =0; i < 10; i++) {
            thread[i].start();
        }
    }

}
