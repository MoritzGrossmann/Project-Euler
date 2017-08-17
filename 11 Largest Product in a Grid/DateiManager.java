import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DateiManager {

    public DateiManager() {

    }
    
    private int[][] grid = new int [20][20];

    public int[][] readFile() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"));
        String line = reader.readLine();

        int i = 0;
        while (line != null) {
            String [] splitted = line.split(" ");
            for (int j = 0; j < splitted.length; j++) {
                grid [i][j] = Integer.parseInt(splitted[j]);
            }
            line = reader.readLine();
            i++;
        }
        return this.grid;
    }

}