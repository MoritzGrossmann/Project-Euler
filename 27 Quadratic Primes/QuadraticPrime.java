public class QuadraticPrime {

    private int a;

    private int b;

    private int consecutivPrimes = 0;

    public QuadraticPrime(int a, int b) {
        this.a = a;
        this.b = b;
    }
    private int function(int a, int b,int n) {
        return square(n) + (a * n) + b;
    }

    private int square(int a) {
        return a * a;
    }

    public long getCoefficient() {
        return a * b;
    }

    public int getConsecutivePrimes() {
        int n = 0;
        SpecialNumber number = new SpecialNumber(function(a, b, n));
        while (number.isPrime()) {
            this.consecutivPrimes++;
            n++;
            number = new SpecialNumber(function(a, b, n));
        }

        return this.consecutivPrimes;
    }
}