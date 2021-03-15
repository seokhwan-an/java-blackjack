package blackjack.domain.card;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import blackjack.domain.gamer.Player;
import blackjack.domain.gamer.Players;
import java.util.List;
import java.util.stream.IntStream;

public class CardManager {

    private final Deck deck;

    private CardManager(final Deck deck) {
        this.deck = deck;
    }

    public static CardManager create() {
        return new CardManager(Deck.create());
    }

    public Hands giveFirstHand() {
        return new Hands(deck.popTwoCards());
    }

    public Card giveCard() {
        return deck.popSingleCard();
    }

    public Players initiateGamers(final List<String> playersNames, final List<Integer> playersMoney) {
        return IntStream.range(0, playersNames.size())
                .mapToObj(i -> new Player(playersNames.get(i), playersMoney.get(i), giveFirstHand()))
                .collect(collectingAndThen(toList(), Players::new));
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }
}