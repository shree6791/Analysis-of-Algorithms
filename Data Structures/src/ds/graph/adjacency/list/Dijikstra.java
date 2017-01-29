package ds.graph.adjacency.list;

import java.util.HashMap;
import java.util.Map;

public class Dijikstra {

	private Vertex<Integer> getVertexForEdge(Vertex<Integer> v, Edge<Integer> e) {
		
		return e.getSrcVertex().equals(v) ? e.getDestVertex() : e.getSrcVertex();
		
	}
	
	public Map<Vertex<Integer>, Integer> shortestPath(Graph<Integer> graph, Vertex<Integer> sourceVertex) {

		Map<Vertex<Integer>, Integer> distance = new HashMap<>();
		Map<Vertex<Integer>, Vertex<Integer>> parent = new HashMap<>();
		BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<>();

		for (Vertex<Integer> vertex : graph.getAllVertex())
			minHeap.add(Integer.MAX_VALUE, vertex);

		minHeap.decrease(sourceVertex, 0);
		parent.put(sourceVertex, null);
		distance.put(sourceVertex, 0);
		
		while (!minHeap.empty()) {

			BinaryMinHeap<Vertex<Integer>>.Node heapNode = minHeap.extractMinNode();
			
			Vertex<Integer> current = heapNode.key;
			distance.put(current, heapNode.weight);

			for (Edge<Integer> edge : current.getEdges()) {

				Vertex<Integer> adjacent = getVertexForEdge(current, edge);

				if (!minHeap.containsData(adjacent)) 
					continue;
				
				int newDistance = (int) (distance.get(current) + edge.getWeight());

				if (minHeap.getWeight(adjacent) > newDistance) {
					minHeap.decrease(adjacent, newDistance);
					parent.put(adjacent, current);
				}
			}
		}
		
		return distance;
		
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

		graph.addEdge(1, 2, 5);
		graph.addEdge(2, 3, 2);
		graph.addEdge(1, 4, 9);
		graph.addEdge(1, 5, 3);
		graph.addEdge(5, 6, 2);
		graph.addEdge(6, 4, 2);
		graph.addEdge(3, 4, 3);

		Dijikstra dsp = new Dijikstra();
		Vertex<Integer> sourceVertex = graph.getVertex(1);

		Map<Vertex<Integer>, Integer> distance = dsp.shortestPath(graph, sourceVertex);
		System.out.print(distance);

	}

}
