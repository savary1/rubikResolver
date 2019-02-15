package rubik;

import aima.core.search.framework.HeuristicFunction;

public class UncompletedSideHeuristicFunction implements HeuristicFunction{
	@Override
	public double h(Object State) {
		EstadoRubik estado = (EstadoRubik) State;
		EstadoRubik objetivo = new EstadoRubik(false);
		int cont = 0, j, k;
		boolean igual = true;
		for(int i = 0; i < EstadoRubik.COLOURS; i++){
			j = 0;
			while (j < EstadoRubik.SIZE && igual){
				k = 0;
				while (k < EstadoRubik.SIZE && igual){
					if (estado.getCasilla(i, j, k) != objetivo.getCasilla(i, j, k)){
						igual = false;
						cont++;
					}
					else
						k++;
				}
				j++;
			}
			igual = true;
		}
		return cont;
	}
}
