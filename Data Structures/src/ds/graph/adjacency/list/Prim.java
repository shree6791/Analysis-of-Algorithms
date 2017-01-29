package ds.graph.adjacency.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prim {

	public List<Edge<Integer>> primMST(Graph<Integer> graph) {

		List<Edge<Integer>> result = new ArrayList<>();
		BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<>();
		Map<Vertex<Integer>, Edge<Integer>> vertexToEdge = new HashMap<>();

		for (Vertex<Integer> v : graph.getAllVertex())
			minHeap.add(Integer.MAX_VALUE, v);

		Vertex<Integer> startVertex = graph.getAllVertex().iterator().next();
		minHeap.decrease(startVertex, 0);

		while (!minHeap.empty()) {

			Vertex<Integer> current = minHeap.extractMin();
			Edge<Integer> spanningTreeEdge = vertexToEdge.get(current);

			if (spanningTreeEdge != null)
				result.add(spanningTreeEdge);

			for (Edge<Integer> edge : current.getEdges()) {

				Vertex<Integer> adjacent = getVertexForEdge(current, edge);

				if (minHeap.containsData(adjacent) && minHeap.getWeight(adjacent) > edge.getWeight()) {
					minHeap.decrease(adjacent, edge.getWeight());
					vertexToEdge.put(adjacent, edge);
				}
			}
		}

		return result;
	}

	private Vertex<Integer> getVertexForEdge(Vertex<Integer> v, Edge<Integer> e) {
		return e.getSrcVertex().equals(v) ? e.getDestVertex() : e.getSrcVertex();
	}

	public static void main(String args[]) {
		
		Graph<Integer> graph = new Graph<>(false);
		
		/*
		 * graph.addEdge(0, 1, 4); graph.addEdge(1, 2, 8); graph.addEdge(2, 3,
		 * 7); graph.addEdge(3, 4, 9); graph.addEdge(4, 5, 10); graph.addEdge(2,
		 * 5, 4); graph.addEdge(1, 7, 11); graph.addEdge(0, 7, 8);
		 * graph.addEdge(2, 8, 2); graph.addEdge(3, 5, 14); graph.addEdge(5, 6,
		 * 2); graph.addEdge(6, 8, 6); graph.addEdge(6, 7, 1); graph.addEdge(7,
		 * 8, 7);
		 */

		graph.addEdge(1, 2, 3);
		graph.addEdge(2, 3, 1);
		graph.addEdge(3, 1, 1);
		graph.addEdge(1, 4, 1);
		graph.addEdge(2, 4, 3);
		graph.addEdge(4, 5, 6);
		graph.addEdge(5, 6, 2);
		graph.addEdge(3, 5, 5);
		graph.addEdge(3, 6, 4);

		Prim prims = new Prim();
		Collection<Edge<Integer>> edges = prims.primMST(graph);
		for (Edge<Integer> edge : edges) {
			System.out.println(edge);
		}
	}

}
