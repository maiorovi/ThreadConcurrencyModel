package chapter3.countdownlatch;

public class Demo {

    public static void main(String[] args) {
        VideoConference videoConference = new VideoConference(10);

        Thread threadConference=new Thread(videoConference);
        threadConference.start();

        for (int i=0; i<10; i++){
            Participant p=new Participant(videoConference, "Participant "+i);
            Thread t=new Thread(p);
            t.start();
        }
    }

}
