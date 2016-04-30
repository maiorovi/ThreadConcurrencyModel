package philosophy_of_java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executors.execute(new LiftOff(10));
        }
        executors.shutdown();
    }
}
