import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Chains {

    private Map<Integer, Integer> pairs = new TreeMap<>();

    private Map<Integer, Integer> factorials = new TreeMap<>();

    public Chains() {
        for (int i = 0; i < 10; i++) {
            this.factorials.put(i, factorial(i));
        }
    }

    public int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public int getCountOfLength(int n) {
        int count = 0;
        for (int i = 1; i <= 1000000; i++) {
            if (getChainLength(i) == n) {
                count++;
            }
        }
        return count;
    }

    private List<Integer> actualChain;

    public int getChainLength(int n) {
        this.actualChain = new ArrayList<>();
        this.actualChain.add(n);
        int lengthOfn;
        int chainLength;
        int permutedFactorial = getPermutedFactorial(n);
        while (!this.actualChain.contains(permutedFactorial)) {

            if (this.pairs.containsKey(permutedFactorial)) {
                int lengthOfLast =  this.pairs.get(permutedFactorial);
                chainLength = this.actualChain.size();
                for (int i = 0; i < chainLength; i++) {
                    this.pairs.put(this.actualChain.get(i), chainLength - i + lengthOfLast);
                }
                lengthOfn = chainLength + lengthOfLast;
                this.pairs.put(n, lengthOfn);
                return lengthOfn;
            } else {
                this.actualChain.add(permutedFactorial);
                permutedFactorial = getPermutedFactorial(permutedFactorial);
            }
        }

        chainLength = this.actualChain.size();
        for (int i = 0; i < chainLength; i++) {
            this.pairs.put(this.actualChain.get(i), chainLength - i);
        }

        return this.actualChain.size();

    }

    public int getPermutedFactorial(int n) {
        int sum = 0;
        while (n != 0) {
            sum += this.factorials.get(n % 10);
            n /= 10;
        }
        return sum;
    }
}
