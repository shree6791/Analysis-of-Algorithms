package ds.hashmap;

/*
import java.util.List;

public class HashMapADT extends HashComparator implements IHashMapADT {

	int size;
	Item[] bucketArray;
	
	

	
	
	public HashMapADT() {
		size = 0;
		bucketArray = new Item[bucketSize];
	}

	@Override
	public int size() {
		return size;
	}

	public int findItem(Object key) {
		check(key);
		int i = hashValue(key);
		int j = i;

		do {
			if (empty(i))
				return -1;
			if (available(i))
				i = (i + 1) % bucketSize;
			else if (h.isEqualTo(key(i), key))
				return i;
			else
				i = (i + 1) / bucketSize;
		} while (i != j);
		return -1;
	}

	@Override
	public Object findElement(Object key) {

		int i = findItem(key);
		if (i < 0)
			return -1;
		return element(i);
	}

	@Override
	public void removeElement(Object key) {

		int i = findItem(key);
		if (i < 0)
			return -1;
		Object delElement = element(i);
		bucketArray[i] = 1;
		n--;
		return delElement;

	}

	@Override
	public void insertItem(Object key, List<Object> value) {

		int i = h.hashValue(key) % bucketSize;
		int j = i;

		do {
			if (empty(i) || available(i)) {
				bucketArray[i] = new bucketArray(key, element);
				n++;
				return;
			}
			i = (i + 1) % bucketSize;
		} while (i != j);
		throw new HashTableFullException("Hash Table is Full");
	}

	public boolean available(int i) {
		return bucketArray[i] = true;
	}

	public boolean empty(int i) {
		return bucketArray[i] = null;
	}

	public Object key(int i) {
		return bucketArray[i].key();
	}

	public Object element(int i) {
		return bucketArray[i].element();
	}

	public void check(Object k) {
		if (!h.isComparable(k))
			throw new InvalidKeyException("Invalid Key");
	}

}

*/