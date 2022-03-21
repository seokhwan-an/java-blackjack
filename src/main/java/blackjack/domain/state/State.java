package blackjack.domain.state;

import blackjack.domain.card.PlayingCard;
import blackjack.domain.card.PlayingCards;
import blackjack.domain.player.Player;
import blackjack.domain.result.Match;

public interface State {

    State draw(PlayingCard playingCard);

    PlayingCards playingCards();

    Match matchResult(Player player);

    State stay();

    boolean isRunning();
}