public class Threadpool extends Thread{

    protected Thread[] threads;

    protected int count;

    public Threadpool(int count) {
        this.count = count;
        this.threads = new Thread[count];
    }

    public void joins() throws InterruptedException {
        for (Thread t : this.threads) {
            t.join();
        }
    }

    @Override 
    public void run() {
        for (Thread t : this.threads) {
            t.start();
        }
    }

    public void add(int index, Thread t) {
        this.threads[index] = t;
    }
}