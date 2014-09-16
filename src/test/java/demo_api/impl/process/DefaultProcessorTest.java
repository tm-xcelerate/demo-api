package demo_api.impl.process;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import demo_api.api.process.AbstractProcessorTest;
import demo_api.api.process.Processor;
import demo_api.api.test.data.TestData;
import demo_api.impl.config.DefaultTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DefaultTestConfig.class, loader = AnnotationConfigContextLoader.class)
public class DefaultProcessorTest extends AbstractProcessorTest {

	@Autowired
	TestData testData;

	@Autowired
	Processor processor;

	@Override
	protected TestData getTestData() {
		return this.testData;
	}

	@Override
	protected Processor getProcessor() {
		return this.processor;
	}
}
