package rubik;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;
import aima.core.search.uninformed.IterativeDeepeningSearch;
import aima.core.search.uninformed.UniformCostSearch;

public class DemoBusquedasNoInformadas {
	static EstadoRubik estadoInicial = new EstadoRubik(true);
	
	public static void main(String[] args) {
		rubikBFSDemo();
		rubikUniformCostDemo();
		rubikDepthSearchDemo();
		rubikIterativeSearchDemo();
	}
	
	private static void rubikBFSDemo(){
		System.out.println("\nRubikBFSDemo-->");
		try{
			// Crear un objeto Problem con la representación de estados y operadores
			Problem problem = new Problem(estadoInicial,
					RubikFunctionFactory.getActionsFunction(), RubikFunctionFactory.getResultFunction(),
					new RubikGoalTest()); // si no hay función de coste en el constructor se usa el coste por defecto
			// si hay función de coste hay que añadir el objeto correspondiente: new MisionerosStepCostFunction()
			// indicar el tipo de búsqueda
			Search search = new BreadthFirstSearch(); // búsqueda en anchura
			// crear un agente que realice la búsqueda sobre el problema
			SearchAgent agent = new SearchAgent(problem, search);
			// escribir la solución encontrada (operadores aplicados) e información sobre los recursos utilizados
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			// Hay que implementar estos métodos en la clase Demo (copiar de aima.gui.demo.search.EightPuzzleDemo)
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private static void rubikUniformCostDemo(){
		System.out.println("\nRubikUniformCostDemo-->");
		try{
			// Crear un objeto Problem con la representación de estados y operadores
			Problem problem = new Problem(estadoInicial,
					RubikFunctionFactory.getActionsFunction(), RubikFunctionFactory.getResultFunction(),
					new RubikGoalTest()); // si no hay función de coste en el constructor se usa el coste por defecto
			// si hay función de coste hay que añadir el objeto correspondiente: new MisionerosStepCostFunction()
			// indicar el tipo de búsqueda
			Search search = new UniformCostSearch(); // búsqueda en anchura
			// crear un agente que realice la búsqueda sobre el problema
			SearchAgent agent = new SearchAgent(problem, search);
			// escribir la solución encontrada (operadores aplicados) e información sobre los recursos utilizados
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			// Hay que implementar estos métodos en la clase Demo (copiar de aima.gui.demo.search.EightPuzzleDemo)
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private static void rubikDepthSearchDemo(){
		System.out.println("\nRubikDepthSearchDemo-->");
		try{
			// Crear un objeto Problem con la representación de estados y operadores
			Problem problem = new Problem(estadoInicial,
					RubikFunctionFactory.getActionsFunction(), RubikFunctionFactory.getResultFunction(),
					new RubikGoalTest()); // si no hay función de coste en el constructor se usa el coste por defecto
			// si hay función de coste hay que añadir el objeto correspondiente: new MisionerosStepCostFunction()
			// indicar el tipo de búsqueda
			Search search = new DepthLimitedSearch(20); // búsqueda en anchura
			// crear un agente que realice la búsqueda sobre el problema
			SearchAgent agent = new SearchAgent(problem, search);
			// escribir la solución encontrada (operadores aplicados) e información sobre los recursos utilizados
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			// Hay que implementar estos métodos en la clase Demo (copiar de aima.gui.demo.search.EightPuzzleDemo)
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private static void rubikIterativeSearchDemo(){
		System.out.println("\nRubikIterativeDeepeningDemo-->");
		try{
			// Crear un objeto Problem con la representación de estados y operadores
			Problem problem = new Problem(estadoInicial,
					RubikFunctionFactory.getActionsFunction(), RubikFunctionFactory.getResultFunction(),
					new RubikGoalTest()); // si no hay función de coste en el constructor se usa el coste por defecto
			// si hay función de coste hay que añadir el objeto correspondiente: new MisionerosStepCostFunction()
			// indicar el tipo de búsqueda
			Search search = new IterativeDeepeningSearch(); // búsqueda en anchura
			// crear un agente que realice la búsqueda sobre el problema
			SearchAgent agent = new SearchAgent(problem, search);
			// escribir la solución encontrada (operadores aplicados) e información sobre los recursos utilizados
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
			// Hay que implementar estos métodos en la clase Demo (copiar de aima.gui.demo.search.EightPuzzleDemo)
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	private static void printInstrumentation(Properties instrumentation) {
		Iterator<Object> keys = instrumentation.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = instrumentation.getProperty(key);
			System.out.println(key + " : " + property);
		}
	}

	private static void printActions(List<Action> actions) {
		for (int i = 0; i < actions.size(); i++) {
			String action = actions.get(i).toString();
			System.out.println(action);
		}
	}
}
