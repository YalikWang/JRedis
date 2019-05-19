package pro.jredis.dict;

/**
 * 基于Hash实现的字典集合<br/>
 * 定义了数据的组织方式，支持使用方指定Hash算法。
 * @author YalikWang
 *
 * @param <K>
 * @param <V>
 */
public class HashDict<K,V> implements Dict<K,V> {
	private HashDictEntry<K,V>[] entrys;
	private HashAlgorithm<K> hashAlgorithm;
	@SuppressWarnings("unchecked")
	public HashDict(HashAlgorithm<K> hashAlgorithm) {
		entrys = new HashDictEntry[10];
		this.hashAlgorithm = hashAlgorithm;
	}
	public HashDict() {
		this(new DefaultHashAlgorithm<>());
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
		return entrys.length;
	}
	@Override
	public boolean exists(K key) {
		return false;
	}
	

}
