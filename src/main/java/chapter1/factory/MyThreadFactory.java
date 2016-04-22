package chapter1.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyThreadFactory implements ThreadFactory {
    private String name;
    private int counter;
    private List<String> stats;

    public MyThreadFactory(String name) {
        this.name = name;
        stats = new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r,name+"-thread_"+counter);
        counter++;
        stats.add(String.format("Created thread %d with name %s on %s\\n",thread.getId(),thread.getName(),new Date()));

        return thread;
    }


    public String getStats() {
        return stats.stream().collect(Collectors.joining("\n")).toString();
    }

}
