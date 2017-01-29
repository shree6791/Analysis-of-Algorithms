package ds.graph.adjacency.list;

import java.util.HashSet;
import java.util.Set;

public class DepthFirstSearch {

	public void DFS(Graph<Integer> graph) {

		Set<Object> visited = new HashSet<Object>();

		for (Vertex<Integer> vertex : graph.getAllVertex())
			if (!visited.contains(vertex.getVertexValue()))
				DFSUtil(vertex, visited);

	}

	private void DFSUtil(Vertex<Integer> v, Set<Object> visited) {

		visited.add(v.getVertexValue());
		System.out.print(v.getVertexValue() + " ");

		for (Vertex<Integer> vertex : v.getAdjacentVertex())
			if (!visited.contains(vertex.getVertexValue()))
				DFSUtil(vertex, visited);

	}

	public static void main(String[] args) {

		DepthFirstSearch dfs = new DepthFirstSearch();
		Graph<Integer> graph = new Graph<Integer>(false);

		graph.addEdge("A", "B", 0);
		graph.addEdge("A", "E", 0);
		graph.addEdge("A", "F", 0);

		graph.addEdge("B", "C", 0);

		graph.addEdge("C", "D", 0);
		graph.addEdge("C", "G", 0);

		graph.addEdge("D", "G", 0);
		graph.addEdge("D", "H", 0);

		graph.addEdge("E", "I", 0);
		graph.addEdge("E", "F", 0);

		graph.addEdge("F", "I", 0);

		graph.addEdge("G", "J", 0);
		graph.addEdge("G", "K", 0);
		graph.addEdge("G", "L", 0);

		graph.addEdge("H", "L", 0);

		graph.addEdge("I", "J", 0);
		graph.addEdge("I", "M", 0);
		graph.addEdge("I", "N", 0);

		graph.addEdge("J", "K", 0);

		graph.addEdge("K", "O", 0);
		graph.addEdge("K", "N", 0);

		graph.addEdge("M", "N", 0);

		graph.addEdge("L", "P", 0);

		graph.addEdge("O", "P", 0);

		System.out.println("DFS Path Traversal \n");
		dfs.DFS(graph);

	}

}
