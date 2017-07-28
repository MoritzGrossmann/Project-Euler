import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        String str = "";
        ArrayList<Character> chars = new ArrayList<>();
        long num = 1;

        while (chars.size() < 1000000) {
            str = String.valueOf(num);
            for (int i = 0; i < str.length(); i++) {
                chars.add(str.charAt(i));
            }
            num ++;
        }
        
        System.out.println(
            ((long) (chars.get(0)) - 48)*
            ((long) (chars.get(9)) - 48)*
            ((long) (chars.get(99)) - 48)*
            ((long) (chars.get(999)) - 48)*
            ((long) (chars.get(9999)) - 48)*
            ((long) (chars.get(99999)) - 48)*
            ((long) (chars.get(999999)) - 48)
        );

    }
}