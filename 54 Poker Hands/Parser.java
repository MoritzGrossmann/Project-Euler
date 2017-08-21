import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Parser implements Closeable {
    private final BufferedReader reader;

    Parser(FileReader in) {
        this.reader = new BufferedReader(in);
    }

    Round getNextRound() throws IOException {
        String nextLine = reader.readLine();
        String[] cardStrings = nextLine.split(" ");

        List<Card> cardList = new LinkedList<>();

        for(String cardString : cardStrings) {
            cardList.add(new Card(cardString));
        }

        return new Round(cardList);
    }

    public void close() throws IOException {
        reader.close();
    }

    boolean hasNext() throws IOException {
        return reader.ready();
    }
}