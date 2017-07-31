package Core;
public class Number {

    private long value;

    public Number(long value) {
        this.value = value;
    }

    public long getValue() {
        return this.value;
    }

    public boolean hasDivisors() {
        for (long i = 2; i < Math.sqrt((double) value); i++) {
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

    public Number subtract(Number n) {
        return new Number(this.getValue() - n.getValue());
    }

    public Number pow(long n) {
        long _value = this.value;
        for (long i = 1; i < n; i++) {
            _value *= value;
        }

        return new Number(_value);
    }

    @Override
    public String toString() {
        return new Long(this.value).toString();
    }
}