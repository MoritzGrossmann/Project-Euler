import java.util.List;

class Round {
    private final PokerHand playerOne;
    private final PokerHand playerTwo;

    Round(List<Card> cardList) {
        List<Card> firstCards = cardList.subList(0, 5);
        this.playerOne = new PokerHand(firstCards);

        List<Card> secondCards = cardList.subList(5, 10);
        this.playerTwo = new PokerHand(secondCards);
    }

    boolean playerOneWins() {
        return playerOne.compareTo(playerTwo) > 0;
    }
}