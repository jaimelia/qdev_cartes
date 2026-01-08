package strategy;

import model.Player;
import java.util.List;

public class LowCardGameEvaluator implements GameEvaluator {
    @Override
    public Player evaluateWinner(List<Player> players) {
        if (players.isEmpty()) return null;

        Player winner = players.get(0);
        int rankValWinner = players.get(0).getHand().getCard(0).getRank().getRank();
        int suitValWinner = players.get(0).getHand().getCard(0).getSuit().getSuit();

        for (int i = 1; i < players.size(); i++) {
            int rankVal = players.get(i).getHand().getCard(0).getRank().getRank();
            int suitVal = players.get(i).getHand().getCard(0).getSuit().getSuit();

            if (rankVal < rankValWinner || (rankVal == rankValWinner && suitVal < suitValWinner)) {
                winner = players.get(i);
                rankValWinner = rankVal;
                suitValWinner = suitVal;
            }
        }
        return winner;
    }
}