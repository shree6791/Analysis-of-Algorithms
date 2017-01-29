package ds.graph.adjacency.list;

import java.util.HashSet;
import java.util.Stack;
import java.util.Set;

public class TopologicalSort<T> {

	public Stack<Vertex<T>> topSort(Graph<T> graph) {

		Stack<Vertex<T>> stack = new Stack<>();
		Set<Vertex<T>> visited = new HashSet<>();

		for (Vertex<T> vertex : graph.getAllVertex()) {

			if (visited.contains(vertex))
				continue;

			topSortUtil(vertex, stack, visited);

		}

		return stack;
	}

	private void topSortUtil(Vertex<T> vertex, Stack<Vertex<T>> stack, Set<Vertex<T>> visited) {

		visited.add(vertex);

		for (Vertex<T> childVertex : vertex.getAdjacentVertex()) {

			if (visited.contains(childVertex))
				continue;

			topSortUtil(childVertex, stack, visited);

		}

		stack.push(vertex);

	}

	public static void main(String[] args) {

		Graph<String> graph = new Graph<>(true);

		graph.addEdge("A", "C", 0);
		graph.addEdge("A", "D", 0);

		graph.addEdge("B", "D", 0);
		graph.addEdge("B", "F", 0);

		graph.addEdge("C", "D", 0);
		graph.addEdge("C", "E", 0);
		graph.addEdge("C", "H", 0);

		graph.addEdge("D", "F", 0);

		graph.addEdge("E", "G", 0);

		graph.addEdge("F", "G", 0);
		graph.addEdge("F", "I", 0);

		graph.addEdge("G", "I", 0);

		graph.addEdge("H", "I", 0);

		/*
		 * graph.addEdge(1, 3, 0); graph.addEdge(1, 2, 0); graph.addEdge(3, 4,
		 * 0); graph.addEdge(5, 6, 0); graph.addEdge(6, 3, 0); graph.addEdge(3,
		 * 8, 0); graph.addEdge(8, 11, 0);
		 * 
		 */

		TopologicalSort<String> sort = new TopologicalSort<String>();
		Stack<Vertex<String>> result = sort.topSort(graph);

		while (!result.isEmpty())
			System.out.println(result.pop());

	}

}
