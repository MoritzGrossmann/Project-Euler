package Problem46;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Threadpool {

    private ArrayList<Thread> threads = new ArrayList<>();

    private int actual = 1;

    private Semaphore sem = new Semaphore(1, true);

    public synchronized int getNext() throws InterruptedException{
        sem.acquire();
        int i = actual++;
        sem.release();
        return i;
    }

    public Threadpool(int count, PentagonNumbers numbers) {
        for (int i = 0; i < count; i++) {
            threads.add(new Worker(this, numbers));
        }
    }

    public void start() {
        for (Thread t : threads) {
            t.start();
        }
    }

    public void join() throws InterruptedException{
        for (Thread t : threads) {
            t.join();
        }
    }
}

class Worker extends Thread {
    
    private PentagonNumbers numbers;

    private Threadpool tp;

    public Worker(Threadpool tp, PentagonNumbers numbers) {
        this.numbers = numbers;
        this.tp = tp;
    }

    private int pentagonal(int n) {
        return n * (3*n - 1) / 2;
    }

    private boolean isPair(int k, int j) {
        return numbers.contains((Integer)(k-j)) && numbers.contains((Integer)(k+j));
    }

    @Override
    public void run() {

        int actual = 0;

        do  {
            try {
                actual = tp.getNext();
                numbers.addPentagonal(pentagonal(actual));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        } while (actual < Math.sqrt(Integer.MAX_VALUE)/ 3);

        for (int i = 0; i < numbers.length(); i++) {
            for (int j = 1; j < numbers.length(); j++) {
                if (isPair(numbers.get(i), numbers.get(j)));
                numbers.addPair(new PentagonalPair(numbers.get(i), numbers.get(j)));
            }
        }
    }
}