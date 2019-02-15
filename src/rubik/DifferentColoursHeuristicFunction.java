package rubik;

import aima.core.search.framework.HeuristicFunction;

public class DifferentColoursHeuristicFunction implements HeuristicFunction{
	
	@Override
	public double h(Object State) {
		EstadoRubik estado = (EstadoRubik) State;
		EstadoRubik objetivo = new EstadoRubik(false);
		int cont = 0;
		
			for (int j = 0; j < EstadoRubik.SIZE; j++){
				for (int k = 0; k < EstadoRubik.SIZE; k++){
					if (objetivo.getCasilla(0, j, k) != estado.getCasilla(0, j, k))
						cont++;
				}
			}
		return cont;
	}
}