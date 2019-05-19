package pro.jredis.dict;

public class HashDict<K,V> implements Dict<K,V> {
	private int loadFactor;
	private int entrySize;
	private HashDictEntry<K,V>[] entrys;
	private HashAlgorithm<K> hashAlgorithm;
	
	public HashDict() {
		entrys = new HashDictEntry[10];
	}
	@Override
	public void put(K key, V value) {
		int hashCode = hashAlgorithm.hashCode(key);
		int entryLength = entrys.length-1;
		int index = entryLength & hashCode;
		HashDictEntry<K, V> newNode = new HashDictEntry<>(key,value);
		if(entrys[index]==null) {
			//新增节点
			entrys[index] = newNode;
		}else {
			//将新增节点插入到第一个位置
			HashDictEntry<K, V> firstNode = entrys[index];
			newNode.setNext(firstNode);
			entrys[index] = newNode;
		}
	}

	@Override
	public V get(K key) {
		int hashCode = hashAlgorithm.hashCode(key);
		int entryLength = entrys.length-1;
		int index = entryLength & hashCode;
		HashDictEntry<K, V> node = entrys[index];
		while(node!=null) {
			if(node.getKey().equals(key)) {
				return node.getValue();
			}
			node = node.getNext();
		}
		return null;
	}

	@Override
	public void remove(K key) {
		
	}
	public int getEntrySize() {
		return entrySize;
	}
	public void setEntrySize(int entrySize) {
		this.entrySize = entrySize;
	}
	@Override
	public boolean exists(K key) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
