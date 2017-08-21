import java.io.FileReader;
import java.io.IOException;

public class Program {
    public static void main(String... args) throws IOException {
        FileReader fr = new FileReader("poker.txt");
        Parser p = new Parser(fr);

        int counter = 0;
        while(p.hasNext()) {
            Round r = p.getNextRound();
            if(r.playerOneWins()) counter++;
        }

        System.out.println(counter);

        p.close();
    }
}