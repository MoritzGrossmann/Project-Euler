public class Card implements Comparable<Card> {

    private final Value value;
    private final Color color;

    Card(Value value, Color color) {
        this.value = value;
        this.color = color;
    }

    Card(String s) {
        this(Value.of(s.charAt(0)), Color.of(s.charAt(1)));
    }

    Value getValue() {
        return value;
    }

    Color getColor() {
        return color;
    }

    @Override
    public int compareTo(Card o) {
        return value.compareTo(o.value);
    }

    @Override
    public String toString() {
        return String.format("%s_%s", value.getChar(), color.getChar());
    }
}