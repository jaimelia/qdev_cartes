package builder;

import factory.DeckFactory;
import factory.DeckType;
import factory.EvaluateFactory;
import factory.EvaluatorType;

public class LowCardNormalDeck implements GameBuilder {
	@Override
	public Game getGame() {
        return new Game(
                EvaluateFactory.makeEvaluator(EvaluatorType.LOWCARD),
                DeckFactory.makeDeck(DeckType.NORMAL)
        );
	}
}
