package rubik;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.HeuristicFunction;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.informed.AStarSearch;
import aima.core.search.informed.GreedyBestFirstSearch;
public class DemoBusquedasInformadas {
	static EstadoRubik estadoInicial = new EstadoRubik(true);
	
	public static void main(String[] args) {
		System.out.println("\nRubikDemo AStar Search (DifferentColoursHeursitic)-->");
		rubikAStarDemo(new DifferentColoursHeuristicFunction());
		System.out.println("\nRubikDemo AStar Search (UncompletedSideHeursitic)-->");
		rubikAStarDemo(new UncompletedSideHeuristicFunction());
		System.out.println("\nRubikDemo GreedyBestFirst Search (DifferentColoursHeursitic)-->");
		rubikGreedyBestFirstDemo(new DifferentColoursHeuristicFunction());
		System.out.println("\nRubikDemo GreedyBestFirst Search (UncompletedSideHeursitic)-->");
		rubikGreedyBestFirstDemo(new UncompletedSideHeuristicFunction());
	}
	
	private static void rubikAStarDemo(HeuristicFunction heuristic) {
		try {
			Problem problem = new Problem(estadoInicial, RubikFunctionFactory.getActionsFunction(),
					RubikFunctionFactory.getResultFunction(), new RubikGoalTest());
			Search search = new AStarSearch(new GraphSearch(), heuristic);
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void rubikGreedyBestFirstDemo(HeuristicFunction heuristic) {
		try {
			Problem problem = new Problem(estadoInicial, RubikFunctionFactory.getActionsFunction(),
					RubikFunctionFactory.getResultFunction(), new RubikGoalTest());
			Search search = new GreedyBestFirstSearch(new GraphSearch(), heuristic);
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
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
