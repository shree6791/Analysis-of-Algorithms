package ds.graph.adjacency.list;

import java.util.HashSet;
import java.util.Set;

public class CycleInDirectedGraph {

	public boolean hasCycle(Graph<Integer> graph) {

		Set<Vertex<Integer>> graySet = new HashSet<>();
		Set<Vertex<Integer>> blackSet = new HashSet<>();
		Set<Vertex<Integer>> whiteSet = new HashSet<>();

		for (Vertex<Integer> vertex : graph.getAllVertex())
			whiteSet.add(vertex);

		while (whiteSet.size() > 0) {

			Vertex<Integer> current = whiteSet.iterator().next();
			if (dfs(current, whiteSet, graySet, blackSet))
				return true;

		}

		return false;
	}

	private boolean dfs(Vertex<Integer> current, Set<Vertex<Integer>> whiteSet, Set<Vertex<Integer>> graySet,
			Set<Vertex<Integer>> blackSet) {

		moveVertex(current, whiteSet, graySet);

		for (Vertex<Integer> adj : current.getAdjacentVertex()) {

			if (blackSet.contains(adj))
				continue;

			if (graySet.contains(adj))
				return true;

			if (dfs(adj, whiteSet, graySet, blackSet))
				return true;

		}

		moveVertex(current, graySet, blackSet);
		return false;

	}

	private void moveVertex(Vertex<Integer> vertex, Set<Vertex<Integer>> sourceSet,
			Set<Vertex<Integer>> destinationSet) {

		sourceSet.remove(vertex);
		destinationSet.add(vertex);

	}

	public static void main(String[] args) {

		Graph<Integer> graph = new Graph<>(true);
		graph.addEdge(1, 2, 0);
		graph.addEdge(1, 3, 0);
		// graph.addEdge(2, 3, 0);
		graph.addEdge(4, 1, 0);
		graph.addEdge(4, 5, 0);
		graph.addEdge(5, 6, 0);
		// graph.addEdge(6, 4, 0);

		CycleInDirectedGraph cidag = new CycleInDirectedGraph();
		boolean isCycle = cidag.hasCycle(graph);
		System.out.println("Directed Graph has Cycle " + isCycle);

	}

}
