package rubik;

import aima.core.agent.Action;
import aima.core.search.framework.StepCostFunction;

public class RubikStepCostFunction implements StepCostFunction{

	@Override
	public double c(Object arg0, Action arg1, Object arg2) {
		return 1;
	}

}
