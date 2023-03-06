package blackjack.domain;

import blackjack.util.CardNumber;
import blackjack.util.CardPickerGenerator;
import blackjack.util.CardSuit;
import java.util.ArrayList;
import java.util.List;

public class Cards {

    private static final int MAX_DECK_SIZE = 6;
    private final List<Card> cards;
    private final CardPickerGenerator cardPickerGenerator;

    private Cards(List<Card> cards, CardPickerGenerator cardPickerGenerator) {
        this.cards = cards;
        this.cardPickerGenerator = cardPickerGenerator;
    }

    public static Cards generator(CardPickerGenerator cardPickerGenerator) {
        List<Card> deck = new ArrayList<>();
        for (int count = 0; count < MAX_DECK_SIZE; count++) {
            numberEngrave(deck);
        }
        return new Cards(deck, cardPickerGenerator);
    }

    private static void numberEngrave(final List<Card> deck) {
        for (CardNumber cardNumber : CardNumber.values()) {
            suitEngrave(deck, cardNumber);
        }
    }

    private static void suitEngrave(final List<Card> deck, final CardNumber cardNumber) {
        for (CardSuit cardSuit : CardSuit.values()) {
            deck.add(new Card(cardNumber, cardSuit));
        }
    }

    public Card pick() {
        return cards.remove(cardPickerGenerator.generator(cards.size()));
    }
}
