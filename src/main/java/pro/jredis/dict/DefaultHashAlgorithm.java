package pro.jredis.dict;

public class DefaultHashAlgorithm<K> implements HashAlgorithm<K> {

	@Override
	public int hashCode(K key) {
		return key.hashCode();
	}

}
