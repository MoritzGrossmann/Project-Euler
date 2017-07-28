public class Program {
    public static void main(String args[]) {

        PentagonNumbers pn = new PentagonNumbers();

        Threadpool tp = new Threadpool(5, pn);

        tp.start();

        try {
            tp.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(pn.getSmallestAbs());
    }
}