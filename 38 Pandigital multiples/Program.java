import java.util.concurrent.Semaphore;

public class Program {
    
    public static void main(String[] args) {

        int counter = 1;

        while(counter < 1000) {
            PandigitalNumber num = new PandigitalNumber(counter);
            if (num.isPandigital()) {
                num.print();
            }
            counter++;
        }


        System.out.println("Ende");
        /*
        PandigitalThreadPool ptp = new PandigitalThreadPool(count);

        for (int i = 0; i < count; i++) {
            ptp.add(i, new Worker(ptp));
        }

        ptp.start();

        try {
            ptp.joins();
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }

        */
    }
}

class PandigitalThreadPool extends Threadpool {

    private Semaphore sem = new Semaphore(1, true);

    private int counter = 1;

    public PandigitalThreadPool(int count) {
        super(count);
    }

    public int getNext() throws InterruptedException{
        sem.acquire();
        int i = counter++;
        sem.release();
        return i;
    }

}

class Worker extends Thread {

    private PandigitalThreadPool ptp;

    public Worker(PandigitalThreadPool ptp) {
        this.ptp = ptp;
    }

    @Override
    public void run() {
        try {
            int i = ptp.getNext();
            while(i < 1000) {
                PandigitalNumber pan = new PandigitalNumber(i);
                if (pan.isPandigital()) {
                    pan.print();
                }
                i = ptp.getNext();
            }
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}