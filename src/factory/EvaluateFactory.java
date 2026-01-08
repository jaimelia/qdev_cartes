package factory;

import strategy.GameEvaluator;
import strategy.HighCardGameEvaluator;
import strategy.LowCardGameEvaluator;

public class EvaluateFactory {
    public static GameEvaluator makeEvaluator(EvaluatorType type) {
        return switch (type) {
            case HIGHCARD -> new HighCardGameEvaluator();
            case LOWCARD -> new LowCardGameEvaluator();
        };
    }
}