package redis.test;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisSentinelTest {

    Jedis jedis;

    @Before
    public void before(){

        jedis=  new Jedis("localhost", 6379);

    }

    @Test
    public void test_serialize(){
        jedis.setex("foo", 60, "bar");


        String value = jedis.get("foo");
        System.out.println(value);
    }


}
