package week02.threads.exercise4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int numCores = Runtime.getRuntime().availableProcessors();

        ExecutorService executor = Executors.newFixedThreadPool(numCores);

        for (int i = 0; i < numCores; i++) {
            executor.execute(new CPUBoundTask());
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed.");
    }

    static class CPUBoundTask implements Runnable {
        @Override
        public void run() {
            long result = 0;
            for (int i = 0; i < Math.pow(10, 7); i++) {
                result += i;
            }
            System.out.println("Task completed with result: " + result);
        }
    }
}
