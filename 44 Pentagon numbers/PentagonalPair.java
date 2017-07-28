public class PentagonalPair implements Comparable<PentagonalPair> {

    private int k;

    private int j;


    public PentagonalPair(int k, int j) {
        this.k = k;
        this.j = j;
    }

    public int abs() {
        return Math.abs(k-j);
    }

    @Override
    public int compareTo(PentagonalPair o2) {
        return this.abs() - o2.abs();
    }
}