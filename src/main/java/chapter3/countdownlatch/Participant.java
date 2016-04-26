package chapter3.countdownlatch;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {

    private VideoConference conference;
    private String name;

    public Participant(VideoConference conference, String name) {
        this.name = name;
        this.conference = conference;
    }

    @Override
    public void run() {
        long duration=(long)(Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        conference.arrive(name);
    }
}
