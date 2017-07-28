import java.util.ArrayList;
import java.util.Arrays;

import jdk.nashorn.internal.runtime.arrays.NumericElements;

public class PandigitalNumber {

    private int value;

    private int pandigitalValue = 0;

    private ArrayList<Integer> digits = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    private int actualMultiply = 1;

    public PandigitalNumber(int value) {
        this.value = value;
    }

    public boolean isPandigital() {
        do {
            int number = value * actualMultiply;
            do {

                int firstdigit = number;
                int factor = 1;

                while (firstdigit >= 10) {
                    firstdigit /= 10;
                    factor *= 10;
                }

                if (digits.contains(firstdigit)) {
                    digits.remove(digits.indexOf(firstdigit));
                    pandigitalValue = pandigitalValue * 10 + firstdigit;
                } else {
                    return false;
                }
                number %= factor;
            } while(number >= 10);

            if (digits.isEmpty()) {
                return true;
            }

            actualMultiply++;
            number = value * actualMultiply;
        } while(true);
    }

    public void print() {
        System.out.println(this.value + " ----> " + this.pandigitalValue);
    }
}