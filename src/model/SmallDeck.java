package model;

public class SmallDeck extends Deck {
    public SmallDeck() {
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                if (rank.getRank() >= 6) {
                    addCard(new Card(suit, rank));
                }
            }
        }
    }
}