package chapter1;

import java.util.concurrent.TimeUnit;

public class Main1 {

    public static void main(String[] args) {
        FileSearch searcher = new FileSearch("D:\\", "SpeakOut Upper Students Book.pdf");
        Thread thread = new Thread(searcher);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}