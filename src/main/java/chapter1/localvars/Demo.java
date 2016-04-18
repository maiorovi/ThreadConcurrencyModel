package chapter1.localvars;

import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) {
        SafeTask unsafeTask = new SafeTask();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(unsafeTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
