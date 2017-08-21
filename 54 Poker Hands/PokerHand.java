import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PokerHand implements Comparable<PokerHand> {
    private final List<Card> cards;
    private final ValueRanking ranking;

    PokerHand(List<Card> cards) {
        List<Card> temp = new ArrayList<>(cards);
        temp.add(new Card(Value.NULL, Color.NULL));
        Collections.sort(temp);
        this.cards = Collections.unmodifiableList(temp);

        ValueRanking straightRanking = straightRanking();

        if(straightRanking != null) {
            ranking = straightRanking;
        } else {
            ranking = pairRanking();
        }
    }

    private ValueRanking straightRanking() {
        if(isStraight() && isFlush()) {
            return new ValueRanking(Ranking.STRAIGHT_FLUSH, cards.get(4).getValue(), null, Collections.emptyList());
        } else if(isFlush()) {
            List<Value> kickers = new LinkedList<>();
            kickers.add(cards.get(2).getValue());
            kickers.add(cards.get(1).getValue());
            kickers.add(cards.get(0).getValue());
            return new ValueRanking(Ranking.FLUSH, cards.get(4).getValue(), cards.get(3).getValue(), kickers);
        } else if(isStraight()) {
            return new ValueRanking(Ranking.STRAIGHT_FLUSH, cards.get(4).getValue(), null, Collections.emptyList());
        } else {
            return null;
        }
    }

    private ValueRanking pairRanking() {
        Value value = null;
        int counter = 0;
        int pair = 0, trips = 0, quads = 0;

        Value primary = null;
        Value secondary = null;
        List<Value> kicker = new LinkedList<>();

        for(Card c : cards) {
            Value current = c.getValue();
            if(value != current) {
                switch(counter) {
                    case 2:
                        pair++;
                        if(primary == null) {
                            primary = value;
                        } else if(trips > 0 || primary.compareTo(current) > 0) {
                            secondary = current;
                        } else {
                            secondary = primary;
                            primary = value;
                        }
                        break;
                    case 3:
                        trips++;
                        secondary = primary;
                        primary = value;
                        break;
                    case 4:
                        quads++;
                        primary = value;
                        break;
                    default:
                        if(value != null) kicker.add(value);
                }
                value = current;
                counter = 1;
            } else {
                counter++;
            }
        }

        if(quads > 0) {
            return new ValueRanking(Ranking.QUADS, primary, secondary, kicker);
        } else if(trips > 0) {
            if(pair > 0) return new ValueRanking(Ranking.FULL_HOUSE, primary, secondary, kicker);
            else return new ValueRanking(Ranking.TRIPS, primary, secondary, kicker);
        } else if(pair == 2) {
            return new ValueRanking(Ranking.TWO_PAIR, primary, secondary, kicker);
        } else if(pair == 1) {
            return new ValueRanking(Ranking.PAIR, primary, secondary, kicker);
        } else {
            return new ValueRanking(Ranking.HIGH_CARD, primary, secondary, kicker);
        }
    }

    private boolean isStraight() {
        for(int i = 0; i < 4; i++) {
            if(cards.get(i).getValue().ordinal() + 1 != cards.get(i+1).getValue().ordinal()) return false;
        }
        return true;
    }

    private boolean isFlush() {
        for(int i = 0; i < 4; i++) {
            if(cards.get(i).getColor() != cards.get(i+1).getColor()) return false;
        }
        return true;
    }

    @Override
    public int compareTo(PokerHand o) {
        return ranking.compareTo(o.ranking);
    }
}