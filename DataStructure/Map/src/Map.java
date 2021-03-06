
public interface Map<K,V> {
	public void add(K key,V value);
	public V remove(K k);
	public boolean contains(K k);
	public V get(K k);
	public void set(K k,V v);
	public int getSize();
	public boolean isEmpty();
}
