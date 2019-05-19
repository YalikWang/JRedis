package pro.jredis.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pro.jredis.db.RedisStorage;


public class TestSimpleAPI {
	
	@Test
	public void testPut() {
		RedisStorage<String,String> redisStorage = new RedisStorage<>();
		redisStorage.put("yalik", "wang");
		String string = redisStorage.get("yalik");
		assertEquals("wang", string);
	}
}
