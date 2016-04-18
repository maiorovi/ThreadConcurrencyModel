package chapter1.exception;

/**
 * Created by Egor on 17.04.2016.
 */
public class Demo {

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());

        thread.start();
    }
}
