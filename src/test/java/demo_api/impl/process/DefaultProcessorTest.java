package demo_api.impl.process;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import demo_api.api.process.AbstractProcessorTest;
import demo_api.impl.config.DefaultTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DefaultTestConfig.class, loader = AnnotationConfigContextLoader.class)
public class DefaultProcessorTest extends AbstractProcessorTest {
}
