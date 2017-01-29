package ds.graph.adjacency.matrix;

//import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class Vertex {

	Object srcVertex;
	boolean visited;
	List<Edge> edges;

	public Vertex(Object srcVertex) {
		super();
		this.visited = false;
		this.srcVertex = srcVertex;
		this.edges = new ArrayList<Edge>();
	}

	public void addEdge(Object weight, Object destName) {

		if (edges.contains(destName))
			return;

		Vertex destVertex = new Vertex(destName);
		Edge e = new Edge(weight, destVertex);
		edges.add(e);

	}

	public String toString() {
		return srcVertex.toString();

	}

}
