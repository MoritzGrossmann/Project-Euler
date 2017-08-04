import java.math.BigInteger;

public class Program {

    public static void main(String args[]) {

        int counter = 0;

        Fraction eins = new Fraction(new BigInteger("1"),new BigInteger("1"));
        Fraction zwei = new Fraction(new BigInteger("2"),new BigInteger("1"));
        Fraction xn = new Fraction(new BigInteger("1"), new BigInteger("2"));

        for (int i = 0; i < 1000; i++) {
            System.out.printf("i = %d\n", i);
            xn = eins.divide(xn.add(zwei));
            Fraction res = eins.add(xn);
            if (res.getNumerator().toString().length() > res.getDenominator().toString().length()) {
                counter++;
                System.out.println(res);
            }
        }

        System.out.println("Anzahl: "+  counter);
    }
}