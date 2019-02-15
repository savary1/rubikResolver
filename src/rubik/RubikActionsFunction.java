package rubik;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;

public class RubikActionsFunction implements ActionsFunction{

	@Override
	public Set<Action> actions(Object arg0) {
		Set<Action> actions = new LinkedHashSet<Action>();
		actions.add(EstadoRubik.L);
		actions.add(EstadoRubik.Lp);
		actions.add(EstadoRubik.F);
		actions.add(EstadoRubik.Fp);
		actions.add(EstadoRubik.R);
		actions.add(EstadoRubik.Rp);
		actions.add(EstadoRubik.B);
		actions.add(EstadoRubik.Bp);
		actions.add(EstadoRubik.U);
		actions.add(EstadoRubik.Up);
		actions.add(EstadoRubik.D);
		actions.add(EstadoRubik.Dp);
		return actions;
	}

}