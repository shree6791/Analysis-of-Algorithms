package ds.graph.adjacency.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

	boolean isDirected = false;
	List<Edge<T>> allEdges;
	Map<Object, Vertex<T>> allVertex;

	public Graph(boolean isDirected) {

		this.isDirected = isDirected;
		allEdges = new ArrayList<Edge<T>>();
		allVertex = new HashMap<Object, Vertex<T>>();

	}

	public List<Edge<T>> getAllEdges() {
		return allEdges;
	}

	public Vertex<T> getVertex(Object element) {
		return allVertex.get(element);
	}

	public Collection<Vertex<T>> getAllVertex() {
		return allVertex.values();
	}

	public Vertex<T> createVertex(Object vertexValue) {

		if (allVertex.containsKey(vertexValue))
			return allVertex.get(vertexValue);

		Vertex<T> vertex = new Vertex<T>(vertexValue);
		allVertex.put(vertexValue, vertex);

		return vertex;
	}

	public void addEdge(Object srcVal, Object destVal, double weight) {

		Vertex<T> srcVertex = createVertex(srcVal);
		Vertex<T> destVertex = createVertex(destVal);
		Edge<T> edge = new Edge<T>(srcVertex, destVertex, isDirected, weight);

		allEdges.add(edge);
		srcVertex.addAdjacentVertex(edge, destVertex);

		if (!isDirected)
			destVertex.addAdjacentVertex(edge, srcVertex);

	}

	@Override
	public String toString() {

		StringBuffer buffer = new StringBuffer();

		for (Edge<T> edge : allEdges)
			buffer.append(edge.getSrcVertex() + " " + edge.getDestVertex() + " " + edge.getWeight() + "\n");

		return buffer.toString();

	}

	/*
	 * public void setDataForVertex(Object id, T data) {
	 * 
	 * if (allVertex.containsKey(id)) { Vertex<T> vertex = allVertex.get(id);
	 * vertex.setData(data); }
	 * 
	 * }
	 */

	public static void main(String[] args) {

		Graph<Integer> graph = new Graph<Integer>(true);
		graph.addEdge("A", "B", 0.5);
		graph.addEdge("A", "C", 1);
		graph.addEdge("B", "D", 2);
		graph.addEdge("C", "D", 0.25);
		graph.addEdge("D", "F", 3);
		graph.addEdge("F", "E", 7);
		// graph.addEdge("E", "A", 4);
		graph.addEdge("E", "C", 1);

	}
}