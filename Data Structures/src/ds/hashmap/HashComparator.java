package ds.hashmap;

public abstract class HashComparator implements IHashMapADT {

	public int hashValue(Object key) {
		return (int) key % bucketSize;
	}

	public boolean isEqualTo(Object tempKey, Object origKey) {
		if (tempKey == origKey)
			return true;
		return false;
	}

}
