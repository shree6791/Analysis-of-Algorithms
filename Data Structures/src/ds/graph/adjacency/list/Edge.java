package ds.graph.adjacency.list;

public class Edge<T> {

	double weight;
	boolean isDirected;
	Vertex<T> srcVertex;
	Vertex<T> destVertex;

	Edge(Vertex<T> srcVertex, Vertex<T> destVertex, boolean isDirected, double weight) {

		this.srcVertex = srcVertex;
		this.destVertex = destVertex;
		this.weight = weight;
		this.isDirected = isDirected;

	}

	public double getWeight() {
		return weight;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public Vertex<T> getSrcVertex() {
		return srcVertex;
	}

	public Vertex<T> getDestVertex() {
		return destVertex;
	}

	@Override
	public String toString() {
		return "Edge [isDirected=" + isDirected + ", srcVertex=" + srcVertex + ", destVertex=" + destVertex
				+ ", weight=" + weight + "]";
	}

	/*
	 * 
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((srcVertex == null) ? 0 :
	 * srcVertex.hashCode()); result = prime * result + ((destVertex == null) ?
	 * 0 : destVertex.hashCode()); return result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return
	 * true; if (obj == null) return false; if (getClass() != obj.getClass())
	 * return false; Edge other = (Edge) obj; if (srcVertex == null) { if
	 * (other.srcVertex != null) return false; } else if
	 * (!srcVertex.equals(other.srcVertex)) return false; if (destVertex ==
	 * null) { if (other.destVertex != null) return false; } else if
	 * (!destVertex.equals(other.destVertex)) return false; return true; }
	 */

}