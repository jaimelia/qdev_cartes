package strategy;

import model.Player;

import java.util.List;

public interface GameEvaluator {
	Player evaluateWinner(List<Player> players);
}
