package ds.graph.adjacency.matrix;

public class Edge {

	Object weight;
	Vertex destVertex;
	boolean isDirected;

	public Edge(Object weight, Vertex destVertex) {
		super();
		this.destVertex = destVertex;
		this.weight = weight;		
	}

	public String toString() {
		return weight.toString();
	}

}
