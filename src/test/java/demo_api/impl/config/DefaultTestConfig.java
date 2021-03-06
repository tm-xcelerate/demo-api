package demo_api.impl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import demo_api.api.config.Config;
import demo_api.api.config.TestConfig;
import demo_api.api.test.data.TestData;
import demo_api.impl.test.data.DefaultTestData;

@Configuration
public class DefaultTestConfig extends DefaultConfig implements Config, TestConfig {

	@Override
	@Bean
	public TestData getTestData() {
		return new DefaultTestData();
	}

	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
}
