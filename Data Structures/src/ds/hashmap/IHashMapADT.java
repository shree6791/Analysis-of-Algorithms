package ds.hashmap;

import java.util.List;

public interface IHashMapADT {

	final int bucketSize = 13;

	public int size();

	public Object findElement(Object key);

	public void removeElement(Object key);

	public void insertItem(Object key, List<Object> value);

}
