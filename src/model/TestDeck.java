package model;

public class TestDeck extends Deck {
    public TestDeck() {
        addCard(new Card(CardSuit.CLUB, CardRank.ACE));
        addCard(new Card(CardSuit.DIAMOND, CardRank.ACE));
    }
}