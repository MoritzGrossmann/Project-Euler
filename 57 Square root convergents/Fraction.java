import java.math.BigInteger;

public class Fraction {

    public BigInteger numerator;

    public BigInteger denominator;

    public Fraction(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public BigInteger getDenominator() {
        return this.denominator;
    }

    public BigInteger getNumerator() {
        return this.numerator;
    }

    public boolean isZero() {
        return this.numerator.longValue() == 0 || this.denominator.longValue() == 0;
    }

    public Fraction add(Fraction f) {

        if (f.isZero()) {
            return this;
        }

        if (this.isZero()) {
            return f;
        }
        
        return new Fraction((this.numerator.multiply(f.denominator)).add(f.numerator.multiply(this.denominator)), this.denominator.multiply(f.denominator)).shortening();
    }

    public Fraction multiply(Fraction f) {
        return new Fraction(this.numerator.multiply(f.numerator), this.denominator.multiply(f.denominator)).shortening();
    }

    public Fraction divide(Fraction f) {
        return new Fraction(this.numerator.multiply(f.denominator), this.denominator.multiply(f.numerator)).shortening();
    }

    public Fraction shortening() {
        BigInteger biggest = numerator.compareTo(denominator) >= 0 ? numerator : denominator;
        BigInteger littlest = numerator.compareTo(denominator) < 0 ? numerator  : denominator;
        BigInteger tmp = new BigInteger("0");
        while (littlest.longValue() != 0) {
            tmp = littlest;
            littlest = biggest.mod(littlest);
            biggest = tmp;
        }

        BigInteger ggt = biggest;

        if (biggest.compareTo(denominator) < 0) {
            return new Fraction(numerator.divide(ggt), denominator.divide(ggt));
        }

        return this;
    }

    @Override
    public String toString() {
        return numerator+"/"+denominator;
    }

    public void print() {
        System.out.println(this.toString());
    }
}