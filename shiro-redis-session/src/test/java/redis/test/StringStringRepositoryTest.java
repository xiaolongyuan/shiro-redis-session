package redis.test;

import io.longyuan.shiro.redissession.session.ShiroSession;
import io.longyuan.shiro.redissession.service.ShiroSessionRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ActiveProfiles("test")
@ContextConfiguration(locations = {
		"classpath:/spring-context.xml"
})
public class StringStringRepositoryTest extends  AbstractJUnit4SpringContextTests{

	@Autowired
	ShiroSessionRepository repo;
	
	@Autowired
	RedisTemplate<String,String> redisTemplate;

	@Before
	public void setUp() {
		ShiroSession session = new ShiroSession("127.0.0.1");

		session.setId("aaaa111111111");
		session.setExpired(false);
		session.setAttribute("id","1000");
		repo.saveSession(session);
	}

	@Test
	public void shouldFindValue() throws InterruptedException {
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		redisTemplate.convertAndSend("shiro.session.uncache","test1");
		redisTemplate.convertAndSend("shiro.session.uncache","test2");
		redisTemplate.convertAndSend("shiro.session.uncache","test3");

		Thread.sleep(1000);
	}
	
}