package ds.graph.adjacency.matrix;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	public List<Vertex> vertex;

	public Graph() {
		vertex = new ArrayList<Vertex>();
	}

	public void addVertex(Object srcName, Object weight, Object destName) {

		Vertex srcVertex = new Vertex(srcName);
		srcVertex.addEdge(weight, destName);
		vertex.add(srcVertex);
		System.out.println(123);

	}

	public static void main(String[] args) {

		Graph g = new Graph();
		g.addVertex("A", 2, "B");
		g.addVertex("B", 3, "C");
		g.addVertex("B", 3, "D");
		System.out.println(123);
	}

}
