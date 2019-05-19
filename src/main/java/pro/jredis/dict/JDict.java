package pro.jredis.dict;

public class JDict<K,V> implements Dict<K,V>{
	private HashDict<K,V>[] hashDict;//长度为2，第一个对象是主要的存储对象，第二个是rehash渐进
	private int size;
	private boolean isRehashing = false;
	private HashAlgorithm hashAlgorithm;
	
	@Override
	public void put(K key, V value) {
		if(isRehashing) {
			//hash中的话，hashDict[0]中不再添加元素
		}
		//rehash检验
		int loadFactor = size/hashDict[0].getEntrySize();
		if(loadFactor>10) {
			//负载因子大于10，进行rehash扩展
		}else if(loadFactor<0.1) {
			//负载因子小于0.1，进行rehash收缩
		}
		
	}
	@Override
	public V get(K key) {
		if(isRehashing) {
			//rehash的过程中，直接查找hashDict[1]
			if(hashDict[1].exists(key)) {
				return hashDict[1].get(key);
			}
		}
		return hashDict[0].get(key);
	}
	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean exists(K key) {
		// TODO Auto-generated method stub
		return false;
	}
}
