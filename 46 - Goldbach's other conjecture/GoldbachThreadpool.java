
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import Core.Number;

public class GoldbachThreadpool {

    private long actual = 9;

    private boolean hasFound = false;

    private ArrayList<Thread> threads = new ArrayList<>();

    private Semaphore sem = new Semaphore(1,true);

    public GoldbachThreadpool(int number) {
        for (int i = 0; i < number; i++) {
            threads.add(new Calculator(this));
        }
    }

    public void start() {
        for (Thread t : threads) {
            t.start();
        }
    }

    public void join() throws InterruptedException {
        for (Thread t : threads) {
            t.join();
        }
    }

    public boolean running() {
        return !hasFound;
    }

    public void found() throws InterruptedException {
        sem.acquire();
        this.hasFound = true;
        sem.release();
    }

    public long getNext() throws InterruptedException {
        sem.acquire();
        long i = actual++;
        sem.release();
        return i;
    }
}

class Calculator extends Thread{

    private GoldbachThreadpool tp;
    public Calculator(GoldbachThreadpool tp) {
        this.tp = tp;
    }

    @Override
    public void run() {
        while(tp.running()) {
            try {
                Number n = new Number(tp.getNext());
                if (n.isOdd() && n.hasDivisors()) {
                    if (!testPrimeAndTwiceSquare(n)) {
                        tp.found();
                        System.out.println(n);
                    }
                }

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean testPrimeAndTwiceSquare(Number n) {
        for (long i = n.getValue() - 2; i > 1; i--) {
            if (new Number(i).isPrime()) {
                Number k = new Number(n.getValue() - i);
                for (long j = 1; j < n.getValue(); j++) {

                    long result = k.getValue() - ((new Number(j).pow(2).getValue()) * 2);
                    if (result < 0) {
                        break;
                    } else  if (result == 0) {
                        return true;
                    } 
                }
            }
        }
        return false;
    } 
}