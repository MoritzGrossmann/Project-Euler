import java.io.IOException;

public class Program {

    public static void main(String[] args) {
        try {
            Grid g = new Grid (new DateiManager().readFile());
            System.out.println(g.getMaxProduct());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}