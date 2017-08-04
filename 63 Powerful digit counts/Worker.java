import java.math.BigInteger;
import java.util.concurrent.Semaphore;

public class Worker extends Thread{

    private Threadpool tp;

    private BigInteger number;

    public Worker(Threadpool tp) {
        this.tp = tp;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.number = tp.getNext();
                if (checkNthPower(this.number)) {
                    tp.add(this.number);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean checkNthPower(BigInteger n) {
        int exponent = n.toString().length();
        BigInteger k = new BigInteger("0");

        int compare = k.pow(exponent).compareTo(n);

        while (compare <= 0) {
            if (compare == 0) {
                return true;
            }
            k = k.add(new BigInteger("1"));
            compare = k.pow(exponent).compareTo(n);
        }
        return false;
    }

}