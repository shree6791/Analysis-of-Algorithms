package ds.graph.adjacency.list;

import java.util.HashSet;
import java.util.Set;

public class CycleInUndirectedGraph<T> {

	public boolean hasCycleDFS(Graph<T> graph) {

		Set<Vertex<T>> visited = new HashSet<Vertex<T>>();

		for (Vertex<T> vertex : graph.getAllVertex()) {

			if (visited.contains(vertex))
				continue;

			boolean flag = hasCycleDFSUtil(vertex, visited, null);

			if (flag)
				return true;

		}

		return false;
	}

	public boolean hasCycleDFSUtil(Vertex<T> vertex, Set<Vertex<T>> visited, Vertex<T> parent) {

		visited.add(vertex);

		for (Vertex<T> adj : vertex.getAdjacentVertex()) {

			if (adj.equals(parent))
				continue;

			if (visited.contains(adj))
				return true;

			boolean hasCycle = hasCycleDFSUtil(adj, visited, vertex);

			if (hasCycle)
				return true;

		}

		return false;
	}

	public static void main(String[] args) {

		CycleInUndirectedGraph<Integer> ciug = new CycleInUndirectedGraph<Integer>();
		Graph<Integer> graph = new Graph<Integer>(false);

		graph.addEdge(0, 1, 0);
		graph.addEdge(1, 2, 0);
		// graph.addEdge(0, 3, 0);
		graph.addEdge(3, 4, 0);
		graph.addEdge(4, 5, 0);
		graph.addEdge(5, 1, 0);

		boolean isCycle = ciug.hasCycleDFS(graph);
		System.out.println("Undirected Graph has Cycle " + isCycle);

	}

}
