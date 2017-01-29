package ds.heap.map.min;

public class Node<T> {

	T key;
	int weight;

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String toString() {
		return key + "=" + weight;
	}

}
