package philosophy_of_java.concurrency;

public class LiftOff implements Runnable {

    private static int count = 0;
    private final int id = count++;
    private int countDown = 10;

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff") + "), ";
    }

    @Override
    public void run() {
        while(countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
}
