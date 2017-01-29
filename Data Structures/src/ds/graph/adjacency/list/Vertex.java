package ds.graph.adjacency.list;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

	Object vertexValue;
	List<Edge<T>> edges;
	List<Vertex<T>> adjacentVertex;

	public int getDegree() {
		return edges.size();
	}

	Vertex(Object vertexValue) {

		edges = new ArrayList<>();
		this.vertexValue = vertexValue;
		adjacentVertex = new ArrayList<>();

	}

	public Object getVertexValue() {
		return vertexValue;
	}

	public List<Edge<T>> getEdges() {
		return edges;
	}

	public List<Vertex<T>> getAdjacentVertex() {
		return adjacentVertex;
	}

	public void addAdjacentVertex(Edge<T> e, Vertex<T> destVertex) {

		edges.add(e);
		adjacentVertex.add(destVertex);

	}

	public String toString() {
		return getVertexValue().toString();
	}

	/*
	 * 
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + (int) (vertexValue ^ (vertexValue >>> 32));
	 * return result; }**
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return
	 * true; if (obj == null) return false; if (getClass() != obj.getClass())
	 * return false; Vertex other = (Vertex) obj; if (vertexValue !=
	 * other.vertexValue) return false; return true; }
	 */

}