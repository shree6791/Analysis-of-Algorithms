package ds.graph.adjacency.list;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {

	int level = -1;
	String startVertexValue = "A";

	public void BFS(Graph<Integer> graph) {

		Set<Object> visited = new HashSet<Object>();
		Queue<Vertex<Integer>> queue = new LinkedList<Vertex<Integer>>();

		visited.add(startVertexValue);
		System.out.print(startVertexValue);
		queue.add(graph.allVertex.get(startVertexValue));

		while (queue.size() != 0) {

			level++;
			int n = queue.size();
			System.out.println();

			for (int q = 0; q < n; q++) {

				Vertex<Integer> visitedVertex = queue.poll();

				for (Vertex<Integer> v : visitedVertex.getAdjacentVertex()) {

					if (!visited.contains(v.getVertexValue())) {
						queue.add(v);
						visited.add(v.getVertexValue());
						System.out.print(v.getVertexValue() + " ");

					}
				}
			}
		}

	}

	public static void main(String[] args) {

		BreadthFirstSearch bfs = new BreadthFirstSearch();
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

		System.out.println("Level Order Path Traversal \n");
		bfs.BFS(graph);

		System.out.println("\nShortest distance bw Start and End Point is : " + bfs.level);
	}

}
