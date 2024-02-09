package week02.threads.exercise3;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddingNumbers {
    //Problem: Samme værdi blev ændret, samt printet ud imens en anden tråd starter.

    public static void main(String[] args) {
        ExecutorService worker = Executors.newFixedThreadPool(17);
        System.out.println("Main starts");
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        AtomicInteger counter = new AtomicInteger(0);

        for (int i = 0; i < 1000; i++) {
            worker.submit(new TaskToAddCount(map, counter));
        }

        System.out.println("Main is done");
        worker.shutdown();
    }

    private static class TaskToAddCount implements Runnable {
        private ConcurrentHashMap<Integer, Integer> map;
        private AtomicInteger counter;

        TaskToAddCount(ConcurrentHashMap<Integer, Integer> map, AtomicInteger counter) {
            this.map = map;
            this.counter = counter;
        }

        @Override
        public void run() {
            try {
                Thread.sleep((int) (Math.random() * 1 + 0));
                int value = counter.getAndIncrement();
                map.putIfAbsent(value, value);
                System.out.println("Task: " + value + ": Map size = " + map.size());
            } catch (InterruptedException ex) {
                System.out.println("Thread was interrupted");
            }
        }
    }
}

