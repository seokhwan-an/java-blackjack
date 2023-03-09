package blackjack.domain.card;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private final List<Card> receivedCards;

    public Hand() {
        this.receivedCards = new ArrayList<>();
    }

    public void hitCard(Card card) {
        receivedCards.add(card);
    }

    public List<Card> getReceivedCards() {
        return receivedCards;
    }
}