package chapter1.factory;

public class Demo {
    public static void main(String[] args) {
        MyThreadFactory threadFactory = new MyThreadFactory("MyThreads");
        Task task = new Task();

        for (int i = 0; i < 10; i++) {
            Thread thread = threadFactory.newThread(task);
            thread.start();
        }

        System.out.println("Going to get thread stats");
        System.out.println("Thread stats: " + threadFactory.getStats());
    }
}
