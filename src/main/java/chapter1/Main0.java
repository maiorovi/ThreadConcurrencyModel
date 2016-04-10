package chapter1;

import java.util.Timer;

public class Main0 {
    public static void main(String[] args) {
        Thread thread = new PrimeGenerator();
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
