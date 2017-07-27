public class Fraction {

    private int numerator;

    private int denominator;

    private int match;


    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public boolean hasSameDigit() {

        if (numerator % 10 == 0 || denominator % 10 == 0) {
            return false;
        }
        if (numerator % 10 == denominator % 10 || numerator % 10 == denominator / 10) {
            this.match = numerator % 10;
        } else {
            if (numerator / 10 == denominator % 10 || numerator / 10 == denominator / 10) {
                this.match = numerator / 10;
            }
        }

        return false;
    }

    public boolean isCurious() {
        if (numerator % 10 == denominator % 10) {
            return ((numerator / 10) / (denominator /10)) == numerator / denominator; 
        } else if (numerator % 10 == denominator / 10){
            return ((numerator / 10) / (denominator % 10)) == numerator / denominator; 
        } else if (numerator / 10 == denominator % 10){
            return ((numerator % 10) / (denominator / 10)) == numerator / denominator; 
        } else if (numerator / 10 == denominator / 10){
            return ((numerator % 10) / (denominator % 10)) == numerator / denominator; 
        } else {
            return false;
        }
    }    
}