package pro.jredis.dict;

public interface HashAlgorithm<K> {
	int hashCode(K key);
}
