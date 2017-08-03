public class SpecialNumber {

    protected int number;
    public SpecialNumber(int number) {
        this.number = number;
    }

    public boolean isPrime() {
        if (this.number < 2) return false;
        for (int i = 2; i < Math.sqrt((double) this.number + 1); i++) {
            if (this.number % i == 0) return false;
        }
        return true;
    }

    public boolean isPalindrome() {
        return new StringBuilder(this.toString()).reverse().toString() == this.toString();
    }

    @Override
    public String toString() {
        return new Integer(this.number).toString();
    }
}