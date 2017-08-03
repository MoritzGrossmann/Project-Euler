
public class Program {

    public static void main(String[] args) {

        int max = 0;

        for (int a = -999; a < 1000; a++) {
            for(int b = -999; b < 1000; b++) {
                QuadraticPrime q = new QuadraticPrime(a, b);
                if (q.getConsecutivePrimes() > max) {
                    max = q.getConsecutivePrimes();
                    System.out.println(a + " " + b +" -> "+ q.getConsecutivePrimes() + " -> "+ q.getCoefficient());
                }
            }
        }

    }
}