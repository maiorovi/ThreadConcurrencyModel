package chapter1;

public class MyTest {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.start();
        while(true) {

        }
    }


}

class MyThread implements Runnable {

    @Override
    public void run() {
        while (true) {

        }
    }
}