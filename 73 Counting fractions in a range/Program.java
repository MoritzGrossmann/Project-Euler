public class Program {

    public static void main(String[] args) {

        int count = 0;
        Fraction half = new Fraction(1, 2);
        Fraction third = new Fraction (1,3);


        Fraction actual;
        for (int d = 2; d <= 12000; d++) {
            for (int n = d/2; n > 0; n--) {
                actual = new Fraction(n,d);
                if (actual.getHCF() != 1) {
                    continue;
                }

                if (actual.compareTo(third) <= 0) {
                    break;
                }

                if (actual.compareTo(half) < 0) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }

}