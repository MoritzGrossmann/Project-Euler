import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class PentagonNumbers {

    private ArrayList<Integer> pentagonals = new ArrayList<>();

    private ArrayList<PentagonalPair> pairs = new ArrayList<>();

    public void addPentagonal(int number) {
        pentagonals.add(number);
    }

    public int get(int index) {
        return this.pentagonals.get(index);
    }

    public int length() {
        return this.pentagonals.size();
    }

    public boolean contains(Integer i) {
        return pentagonals.contains(i);
    }

    public void addPair(PentagonalPair pair) {
        pairs.add(pair);
    }

    public int getSmallestAbs() {
        Collections.sort(pairs, new Comparator<PentagonalPair>() {
            @Override
            public int compare(PentagonalPair o1, PentagonalPair o2)
            {

                return  o1.compareTo(o2);
            }
        });

        return pairs.get(0).abs();
    }
}