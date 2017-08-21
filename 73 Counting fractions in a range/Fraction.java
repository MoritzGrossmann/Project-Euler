public class Fraction implements Comparable<Fraction>{

    public int numerator;

    public int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getHCF() {
        int biggest = numerator - denominator >= 0 ? numerator : denominator;
        int littlest = numerator - denominator < 0 ? numerator  : denominator;
        int tmp = 0;
        while (littlest != 0) {
            tmp = littlest;
            littlest = biggest % littlest;
            biggest = tmp;
        }
        return biggest;
    }

    public boolean isCurious() {
        if         (numerator % 10 == denominator % 10) {
            return new Fraction(this.numerator / 10, this.denominator / 10).equals(this); 
        } else if  (numerator % 10 == denominator / 10) {
            return new Fraction(this.numerator / 10, this.denominator % 10).equals(this); 
        } else if  (numerator / 10 == denominator % 10) {
            return new Fraction(this.numerator % 10, this.denominator / 10).equals(this); 
        } else if  (numerator / 10 == denominator / 10) {
           return new Fraction(this.numerator % 10, this.denominator % 10).equals(this); 
        } else {
            return false;
        }
    }

    public boolean isZero() {
        return this.numerator == 0 || this.denominator == 0;
    }

    public boolean isTrivial() {
        return (this.numerator % 10 == 0 && this.denominator % 10 == 0) || this.numerator == this.denominator;
    }

    public boolean equals(Fraction f) {
        return this.numerator * f.denominator == this.denominator * f.numerator;
    }

    public Fraction add(Fraction f) {

        if (f.isZero()) {
            return this;
        }

        if (this.isZero()) {
            return f;
        }
        
        return new Fraction(this.numerator * f.denominator + f.numerator * this.denominator, this.denominator * f.denominator).shortening();
    }

    public Fraction substract(Fraction f) {

        if (f.isZero()) {
            return this;
        }

        if (this.isZero()) {
            return f;
        }

        return new Fraction(this.numerator * f.denominator - f.numerator * this.denominator, this.denominator * f.denominator).shortening();
    }

    public Fraction multiply(Fraction f) {
        return new Fraction(this.numerator * f.numerator, this.denominator * f.denominator).shortening();
    }

    public Fraction divide(Fraction f) {
        return new Fraction(this.numerator * f.denominator, this.denominator * f.numerator).shortening();
    }

    public Fraction shortening() {
        int hcf = this.getHCF();
        return new Fraction(this.numerator / hcf, denominator / hcf);
    }

    @Override
    public String toString() {
        return numerator+"/"+denominator;
    }

    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public int compareTo(Fraction f) {
        return this.numerator * f.denominator - this.denominator * f.numerator;
    }
}