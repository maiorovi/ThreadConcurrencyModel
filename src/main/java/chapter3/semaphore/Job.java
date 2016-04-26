package chapter3.semaphore;

public class Job implements Runnable {

    private PrintingQueue printingQueue;

    public Job(PrintingQueue printingQueue) {
        this.printingQueue = printingQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a job\n",Thread.currentThread().getName());
        printingQueue.printJob(new Object());
        System.out.printf("%s: The document has been printed\n",Thread.currentThread().getName());

    }
}
