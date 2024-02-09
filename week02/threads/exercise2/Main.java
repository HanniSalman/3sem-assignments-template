package week02.threads.exercise2;

public class Main {
    private static class Counter {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }


        public int getCount() {
            return count;
        }
    }
}

