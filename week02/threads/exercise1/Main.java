package week02.threads.exercise1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



//Dette er hvad der er stillet af krav til den første opgave med threads. Det under denne main klasse er ekstra i forhold til at printe det ud i alfabetisk rækkefølge.

public class Main {
    /*public static void main(String[] args) throws InterruptedException {
        ExecutorService worker = Executors.newFixedThreadPool(4);

        char currentChar = 'A';

        for (char c = 'A'; c <= 'Z'; c++) {
            char finalChar = c;
            worker.submit(() -> {
                for (int i = 0; i < 3; i++) {
                    System.out.print(finalChar);
                }
                System.out.println();
            });
        }
        worker.shutdown();

    }*/


    public static void main(String[] args) throws InterruptedException {
        ExecutorService worker = Executors.newFixedThreadPool(4);
        Counter counter = new Counter();

        for (int i = 0; i < 26; i += 4) {
            char startChar = (char) ('A' + i);
            char endChar = (char) Math.min('Z', startChar + 3);

            worker.submit(new CounterThread(counter, startChar, endChar));
        }

        worker.shutdown();
    }

    private static class Counter {
        private int count = 0; //Holder styr på hvilket bogstav der printes efter.
        private final Object lock = new Object();  //Sikre kun en tråd kan ændre værdien af count

        public void incrementAndPrint(char c) {
            synchronized (lock) {
                while ((c - 'A') != count) { // Loop der venter til det er den rigtige threads tur til at printe næste bogstav
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 0; i < 3; i++) {
                    System.out.print(c);
                }
                System.out.println();
                count++;

                lock.notifyAll();
            }
        }
    }

    private static class CounterThread extends Thread {
        private final Counter counter;
        private final char startChar;
        private final char endChar;

        public CounterThread(Counter counter, char startChar, char endChar) {
            this.counter = counter;
            this.startChar = startChar;
            this.endChar = endChar;
        }

        @Override
        public void run() {
            for (char c = startChar; c <= endChar; c++) {
                counter.incrementAndPrint(c);
            }
        }
    }

}
