package in.cmss.icici.uotm.core.redis.util;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


import in.cmss.icici.uotm.identity.vo.Employee;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class RedisConnectionFactory {
	
	@Value("${spring.redis.port}")
	int port;
	@Value("${spring.redis.host}")
	String host;
	@Value("${spring.redis.password}")
	String password;

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		String decodedPassword= decodedValue(password);
		log.info("jedisConnectionDetails = [host : " + host + "; port : " + port + "; password : " + password + "; ]");
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName(host);
		jedisConnectionFactory.setPort(port);
		if (password != null)
			jedisConnectionFactory.setPassword(decodedPassword);
		return jedisConnectionFactory;
	}

	private String decodedValue(String encodedString) {
		return new String(Base64.getDecoder().decode(encodedString));
	}

	@Bean
	public RedisTemplate<String, Employee> redisTemplate() {
		RedisTemplate<String, Employee> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	
}
