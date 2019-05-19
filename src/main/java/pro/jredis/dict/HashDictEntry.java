package pro.jredis.dict;

public class HashDictEntry<K,V> {
	private K key;
	private V value;
	private HashDictEntry<K,V> next;
	
	public HashDictEntry(K k,V v) {
		this.key = k;
		this.value = v;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public HashDictEntry<K,V> getNext() {
		return next;
	}
	public void setNext(HashDictEntry<K,V> next) {
		this.next = next;
	}
	
}
