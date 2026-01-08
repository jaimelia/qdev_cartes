package strategy;

import model.Player;

import java.util.List;

public class HighCardGameEvaluator implements GameEvaluator {

	@Override
	public Player evaluateWinner(List<Player> players) {
		if (players.isEmpty()) {
			return null;
		}

		Player winner = players.getFirst();
		int rankValWinner = players.getFirst().getHand().getCard(0).getRank().getRank();
		int colorValWinner = players.getFirst().getHand().getCard(0).getSuit().getSuit();

		for (int i = 1; i < players.size(); i++) {
			int rankVal = players.get(i).getHand().getCard(0).getRank().getRank();
			int colorVal = players.get(i).getHand().getCard(0).getSuit().getSuit();

			if (rankVal > rankValWinner || rankVal == rankValWinner && colorVal > colorValWinner) {
				winner = players.get(i);
				rankValWinner = rankVal;
				colorValWinner = colorVal;
			}
		}

		return winner;
	}
}
