import java.util.HashMap;
import java.util.Map;

public enum Color {
    Spades ('S'),
    Hearts ('H'),
    Diamonds ('D'),
    Clubs ('C'),
    NULL ('N');

    private final char colorChar;

    private static final Map<Character, Color> valueMap = new HashMap<>();

    static {
        for(Color c : Color.values()) {
            valueMap.put(c.getChar(), c);
        }
    }

    Color(char cardString) {
        this.colorChar = cardString;
    }

    public char getChar() {
        return colorChar;
    }

    public static Color of(char value) {
        Color c = valueMap.get(value);
        if(c == null) return NULL;
        return c;
    }
}