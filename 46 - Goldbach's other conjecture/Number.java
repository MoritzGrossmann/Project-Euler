public class Number {

    private int value;

    public Number(int value) {
        this.value = value;
    }

    public boolean hasDivisors() {
        for (int i = 2; i < Math.sqrt((double) value); i++) {
            if (value % i == 0) {
                return true;
            }
        }
        
        return false;
    }

    public boolean isPrime() {
        return !hasDivisors();
    }

    public boolean isOdd() {
        return value % 2 != 0;
    }

    public boolean isEven() {
        return !isOdd();
    }
    public boolean isComposite() {
        return isOdd() && hasDivisors();
    }

    public Number pow(int n) {
        int _value = this.value;
        for (int i = 1; i < n; i++) {
            _value *= value;
        }

        return new Number(_value);
    }

    @Override
    public String toString() {
        return new Integer(this.value).toString();
    }
}