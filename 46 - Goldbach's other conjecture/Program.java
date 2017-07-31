
public class Program {

    public static void main(String[] args) {

        GoldbachThreadpool tp = new GoldbachThreadpool(5);
        tp.start();

        try {
            tp.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}