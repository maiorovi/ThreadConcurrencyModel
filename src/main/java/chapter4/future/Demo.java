package chapter4.future;

import sun.nio.ch.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) {
        ThreadPoolExecutor execService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        List<Future<Integer>> resultList = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            int local = rnd.nextInt(10);
            Future<Integer> result = execService.submit(new FactorialCalculator(local));
            resultList.add(result);
        }

        do {
            System.out.printf("Main: Number of Completed Tasks: %d\n", execService.getCompletedTaskCount());

            for (int i = 0; i < resultList.size(); i++) {
                Future<Integer> result = resultList.get(i);
                System.out.printf("Main: Task %d: %s\n", i, result.isDone());
            }

            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (execService.getCompletedTaskCount() < resultList.size());

        System.out.printf("Main: Results\n");
        for (int i = 0; i < resultList.size(); i++) {
            Future<Integer> result = resultList.get(i);
            Integer number = null;
            try {
                number = result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.printf("Main: Task %d: %d\n", i, number);
        }

        execService.shutdown();
    }
}
