package builder;

import factory.DeckFactory;
import factory.DeckType;
import factory.EvaluateFactory;
import factory.EvaluatorType;

public class HighCardNormalDeck implements GameBuilder {
	@Override
	public Game getGame() {
        return new Game(
                EvaluateFactory.makeEvaluator(EvaluatorType.HIGHCARD),
                DeckFactory.makeDeck(DeckType.NORMAL)
        );
	}
}
