package rubik;

import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;

public class RubikFunctionFactory {
	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;
	
	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new RubikActionsFunction();
		}
		return _actionsFunction;
	}
	
	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new RubikResultFunction();
		}
		return _resultFunction;
	}
}
