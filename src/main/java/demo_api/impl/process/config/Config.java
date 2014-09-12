package demo_api.impl.process.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo_api.api.process.Processor;
import demo_api.impl.process.DefaultProcessor;

@Configuration
public class Config {

	@Bean
	public Processor getProcessor() {
		return new DefaultProcessor();
	}
}
