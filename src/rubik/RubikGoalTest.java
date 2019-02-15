package rubik;

import aima.core.search.framework.GoalTest;

public class RubikGoalTest implements GoalTest{
	
	EstadoRubik goal = new EstadoRubik(false);
	
	@Override
	public boolean isGoalState(Object state) {
		EstadoRubik estado = (EstadoRubik) state; 
		return estado.equals(goal);
	}

}
