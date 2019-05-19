package pro.jredis.db;

public class RedisValue<V> {
	private static long defaultLiveTime = 100000;
	private long createTime;
	private long dueTime;
	private V value;
	public RedisValue() {
		
	}
	public RedisValue(V value,long liveTime) {
		this.value = value;
		createTime = System.currentTimeMillis();
		//TODO:溢出检查
		dueTime = createTime + defaultLiveTime;
	}
	public RedisValue(V value) {
		this(value,defaultLiveTime);
	}
	public boolean isOutdated() {
		return false;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public long getDueTime() {
		return dueTime;
	}
	public void setDueTime(long dueTime) {
		this.dueTime = dueTime;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
}
