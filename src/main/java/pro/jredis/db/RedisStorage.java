package pro.jredis.db;

import pro.jredis.dict.JDict;

/**
 * 数据存储仓库
 * 主要进行数据持有，生命周期管理等
 * @author YalikWang
 *
 * @param <K>
 * @param <V>
 */
public class RedisStorage<K extends Object,V> {
	private JDict<K,RedisValue<V>> jDict = new JDict<>();
	
	public void put(K key,V value) {
		jDict.put(key, new RedisValue<>(value));
	}
	
	public V get(K key) {
		RedisValue<V> redisValue = jDict.get(key);
		if(redisValue!=null) {
			if(redisValue.isOutdated()) {
				jDict.remove(key);
				return null;
			}
			return redisValue.getValue();
		}
		return null;
	}
	
	public boolean exists(Object key) {
		return false;
	}
}
