package chapter4.future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator implements Callable<Integer>{
    private int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {

        int result = calculateFactorial(number);
        System.out.printf("%s: %d\n",Thread.currentThread().getName(),result);

        return result;
    }

    private int calculateFactorial(int n) throws InterruptedException {
        if (n != 0) {
            TimeUnit.MILLISECONDS.sleep(20);
            return n * calculateFactorial(n-1);
        } else {
            TimeUnit.MILLISECONDS.sleep(20);
            return 1;
        }
    }
}
