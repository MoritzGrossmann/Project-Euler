import java.util.ArrayList;
import java.math.BigInteger;
import java.util.concurrent.Semaphore;

public class Threadpool {

    private ArrayList<Thread> threads = new ArrayList<>();
    private BigInteger number = new BigInteger("0");
    private int count = 0;
    private Semaphore readSemaphore = new Semaphore(1, true);
    private Semaphore writeSemaphore = new Semaphore(1,true);

    public Threadpool(int count) {
        for (int i = 0; i < count; i++) {
            this.threads.add(new Worker(this));
        }
    }

    public void start() {
        for (Thread t : threads) {
            t.start();
        }
    }

    public BigInteger getNext() throws InterruptedException {
        readSemaphore.acquire();
        BigInteger b = number;
        //System.out.println("Check: " + b.toString());
        number = number.add(new BigInteger("1"));
        readSemaphore.release();
        return b;
    }

    public void add(BigInteger b) throws InterruptedException{
        writeSemaphore.acquire();
        count++;
        System.out.printf("Aktuelle Anzahl: %d  -> Aktuelle Zahl: %s\n", this.count, b.toString());
        writeSemaphore.release();
    }

    public int getCount() {
        return this.count;
    }

}