package controller;

import builder.Game;
import model.*;
import strategy.GameEvaluator;
import view.GameViewable;
import view.GameViewables;

import java.util.ArrayList;
import java.util.List;

public class GameController {
	private final GameViewables gameViewables;
	private final GameEvaluator gameEvaluator;
	private final List<Player> players;
	private final Deck deck;

	private GameState gameState;

    public GameController(Game game, GameViewable gameViewable) {
        this.deck = game.getDeck();
        this.gameViewables = new GameViewables();
        this.gameViewables.addGameViewable(gameViewable);
        gameViewable.setController(this);

        this.gameState = GameState.AddingPlayer;
        this.players = new ArrayList<>();
        this.gameEvaluator = game.getGe();
        runOneStep();
    }

	public void runOneStep() {
		switch (gameState) {
			case AddingPlayer -> gameViewables.promptForPlayerName();
			case CardDealt -> gameViewables.promptForFlip();
			case WinnerRevealed -> gameViewables.promptForNewGame();
		}
	}

    public void addPlayer(String name) {
        if (gameState != GameState.AddingPlayer || players.size() >= 5) {
            return;
        }

        players.add(new Player(name));

        for (int i = 0; i < players.size(); i++) {
            gameViewables.showPlayerName(i, players.get(i).getName());
        }

        runOneStep();
    }

	public void startGame() {
		deck.shuffle();
		for (int i = 0; i < players.size(); i++) {
			players.get(i).getHand().addCard(deck.removeLast());
			gameViewables.showFaceDownCardForPlayer(i, players.get(i).getName());
		}

		gameState = GameState.CardDealt;
		runOneStep();
	}

	public void flipCards() {
		for (int i = 0; i < players.size(); i++) {
			players.get(i).getHand().getCard(0).flip();
			Card card = players.get(i).getHand().getCard(0);
			gameViewables.showCardForPlayer(i, players.get(i).getName(), card.getRank().name(), card.getSuit().name());
		}

		evaluateWinner();

		rebuildDeck();

		gameState = GameState.WinnerRevealed;
		runOneStep();
	}

	void evaluateWinner() {
		Player winner = this.gameEvaluator.evaluateWinner(players);
		if (winner != null) {
			displayWinner(winner.getName());
		}
	}

	void displayWinner(String winnerName) {
		gameViewables.showWinner(winnerName);
	}

	void rebuildDeck() {
		for (Player player : players) {
			deck.addCard(player.getHand().getCard(0));
			player.getHand().removeCard(0);
		}
	}

	public void addView(GameViewable gameViewable) {
		this.gameViewables.addGameViewable(gameViewable);
	}

	public boolean atLeastOnePlayer() {
		return !players.isEmpty();
	}
}
