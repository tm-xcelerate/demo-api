package demo_api.api.config;

import org.springframework.context.annotation.Configuration;

import demo_api.api.process.Processor;

@Configuration
public interface Config {

	Processor getProcessor();
}
