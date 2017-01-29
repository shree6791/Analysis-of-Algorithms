package ds.graph.adjacency.list;

import java.util.LinkedHashSet;
import java.util.Set;

public class PrintPathFromSrcToDest {

	// Print All Paths From Source Vertex To Destination Vertex

	private void printPath(Vertex<Integer> current, Vertex<Integer> destination, Set<Vertex<Integer>> visited) {

		if (visited.contains(current))
			return;

		if (destination.equals(current)) {

			for (Vertex<Integer> v : visited)
				System.out.print(v.getVertexValue() + " ");

			System.out.println(destination.getVertexValue());
			return;

		}

		visited.add(current);

		for (Vertex<Integer> child : current.getAdjacentVertex())
			printPath(child, destination, visited);

		visited.remove(current);

	}

	public static void main(String args[]) {

		Graph<Integer> graph = new Graph<Integer>(false);
		graph.addEdge(1, 2, 0);
		graph.addEdge(1, 3, 0);
		graph.addEdge(2, 4, 0);
		graph.addEdge(2, 5, 0);
		graph.addEdge(3, 6, 0);
		graph.addEdge(5, 6, 0);
		graph.addEdge(5, 7, 0);
		graph.addEdge(6, 7, 0);
		graph.addEdge(4, 7, 0);
		graph.addEdge(1, 8, 0);
		graph.addEdge(8, 9, 0);
		graph.addEdge(9, 1, 0);

		Vertex<Integer> src = graph.getVertex(1);
		Vertex<Integer> dest = graph.getVertex(7);
		Set<Vertex<Integer>> visited = new LinkedHashSet<Vertex<Integer>>();

		PrintPathFromSrcToDest pp = new PrintPathFromSrcToDest();
		pp.printPath(src, dest, visited);

	}
}