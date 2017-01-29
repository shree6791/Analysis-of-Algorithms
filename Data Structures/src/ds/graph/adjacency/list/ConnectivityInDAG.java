package ds.graph.adjacency.list;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ConnectivityInDAG {

	public boolean scc(Graph<Integer> graph) {

		Deque<Vertex<Integer>> stack = new ArrayDeque<Vertex<Integer>>();
		Map<Vertex<Integer>, Boolean> visited = new HashMap<Vertex<Integer>, Boolean>();

		for (Vertex<Integer> vertex : graph.getAllVertex()) {

			if (visited.containsKey(vertex))
				continue;

			DFSUtil(vertex, visited, stack);

		}

		System.out.println(stack);

		Graph<Integer> reverseGraph = new Graph<Integer>(true);
		Map<Object, Vertex<Integer>> vertexMap = new HashMap<Object, Vertex<Integer>>();

		for (Edge<Integer> edge : graph.getAllEdges())
			reverseGraph.addEdge(edge.getDestVertex().getVertexValue(), edge.getSrcVertex().getVertexValue(),
					edge.getWeight());

		for (Vertex<Integer> vertex : reverseGraph.getAllVertex())
			vertexMap.put(vertex.getVertexValue(), vertex);

		visited.clear();
		Vertex<Integer> vertex = vertexMap.get(stack.poll().getVertexValue());
		DFSUtil1(vertex, visited);

		for (Vertex<Integer> testVertex : reverseGraph.getAllVertex())
			if (!visited.containsKey(testVertex))
				return false;

		return true;
	}

	private void DFSUtil(Vertex<Integer> vertex, Map<Vertex<Integer>, Boolean> visited, Deque<Vertex<Integer>> stack) {

		visited.put(vertex, true);

		for (Vertex<Integer> v : vertex.getAdjacentVertex()) {

			if (visited.containsKey(v))
				continue;

			DFSUtil(v, visited, stack);

		}
		stack.offerFirst(vertex);
	}

	private void DFSUtil1(Vertex<Integer> vertex, Map<Vertex<Integer>, Boolean> visited) {

		visited.put(vertex, true);

		for (Vertex<Integer> v : vertex.getAdjacentVertex()) {

			if (visited.containsKey(v))
				continue;

			DFSUtil1(v, visited);
		}
	}

	public static void main(String args[]) {

		Graph<Integer> graph = new Graph<Integer>(true);
		graph.addEdge(1, 0, 0);
		graph.addEdge(2, 1, 0);
		graph.addEdge(0, 2, 0);
		graph.addEdge(0, 3, 0);
		graph.addEdge(3, 4, 0);
		graph.addEdge(4, 2, 0);

		ConnectivityInDAG cidag = new ConnectivityInDAG();
		boolean result = cidag.scc(graph);
		System.out.println(result);
	}

}
