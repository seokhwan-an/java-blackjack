package blackjack.domain;

import blackjack.util.CardPickerGenerator;
import blackjack.util.WinningResult;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BlackjackGame {

    private static final String DEALER_NAME = "딜러";
    private static final int FIRST_HIT_COUNT = 2;

    private final Participants participants;
    private final Cards cards;

    public BlackjackGame(Participants participants, Cards cards) {
        this.participants = participants;
        this.cards = cards;
    }

    public Map<Participant, WinningResult> generatePlayersResult() {
        Map<Participant, WinningResult> playersResult = new LinkedHashMap<>();
        Dealer dealer = extractDealer();
        List<Participant> players = extractPlayers();
        for (Participant player : players) {
            WinningResult dealerResult = dealer.judgeWinOrLose(player);
            playerResultSave(playersResult, player, dealerResult);
        }
        return playersResult;
    }

    public List<WinningResult> generateDealerResult() {
        List<WinningResult> dealerResult = new ArrayList<>();
        Dealer dealer = extractDealer();
        List<Participant> players = extractPlayers();
        for (Participant player : players) {
            dealerResult.add(dealer.judgeWinOrLose(player));
        }
        return dealerResult;
    }

    public void settingGame() {
        for (Participant participant : participants.getParticipants()) {
            firstHitRule(participant);
        }
    }

    private void playerResultSave(final Map<Participant, WinningResult> playersResult, final Participant player, final WinningResult dealerResult) {
        if (dealerResult == WinningResult.WIN) {
            playersResult.put(player, WinningResult.LOSE);
        }
        if (dealerResult == WinningResult.LOSE) {
            playersResult.put(player, WinningResult.WIN);
        }
        if (dealerResult == WinningResult.PUSH) {
            playersResult.put(player, WinningResult.PUSH);
        }
    }

    private List<Participant> extractPlayers() {
        List<Participant> players = participants.getParticipants().stream()
            .filter(participant -> !participant.getParticipantName().equals(new ParticipantName(DEALER_NAME)))
            .collect(Collectors.toList());
        return players;
    }

    private Dealer extractDealer() {
        Dealer dealer = (Dealer) participants.getParticipants().stream()
            .filter(participant -> participant.getParticipantName().equals(new ParticipantName(DEALER_NAME)))
            .findFirst()
            .get();
        return dealer;
    }

    private void firstHitRule(final Participant participant) {
        for (int count = 0; count < FIRST_HIT_COUNT; count++) {
            participant.hit(cards.pick());
        }
    }
}
