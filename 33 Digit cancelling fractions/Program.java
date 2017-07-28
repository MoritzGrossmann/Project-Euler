public class Program {

    public static void main(String[] args) {

        Fraction sum = new Fraction(1,1);

        for (int i = 10; i < 100; i++) {
            for (int j = 10; j < i; j++) {
                Fraction f = new Fraction(j, i);
                if (f.isCurious() && !f.isTrivial()) {
                    sum = sum.multiply(f);
                    f.print();
                }
            }
        }

        System.out.println("Produkt: " + sum.shortening());
    }
}