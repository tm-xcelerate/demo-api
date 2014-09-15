package demo_api.impl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import demo_api.api.config.Config;
import demo_api.api.config.TestConfig;
import demo_api.api.test.data.DefaultTestData;
import demo_api.api.test.data.TestData;

@Configuration
public class DefaultTestConfig extends DefaultConfig implements Config, TestConfig {

	@Override
	@Bean
	public TestData getTestData() {
		return DefaultTestData.getInstance();
	}

	@Override
	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
}
