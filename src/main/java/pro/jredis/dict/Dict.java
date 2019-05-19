package pro.jredis.dict;

public interface Dict<K,V> {
	void put(K key,V value);
	V get(K key);
	void remove(K key);
	boolean exists(K key);
}
