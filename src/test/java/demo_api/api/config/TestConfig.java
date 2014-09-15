package demo_api.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo_api.api.test.data.TestData;

@Configuration
public interface TestConfig {
	@Bean
	TestData getTestData();
}
