import builder.Game;
import builder.HighCardSmallDeck;
import controller.GameController;
import factory.DeckFactory;
import factory.DeckType;
import strategy.HighCardGameEvaluator;
import view.GameSwing;

public class App {
	public static void main(String[] args) {
		GameSwing view = new GameSwing();
		view.createAndShowGUI();

		Game game = new HighCardSmallDeck().getGame();

		//CommandLineView view = new CommandLineView();

		GameController gameController = new GameController(game, view);
		gameController.runOneStep();
	}
}
