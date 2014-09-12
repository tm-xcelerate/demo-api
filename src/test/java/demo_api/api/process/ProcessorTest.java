package demo_api.api.process;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import demo_api.api.process.model.Message;
import demo_api.api.test.data.MessageData;
import demo_api.impl.config.DefaultTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DefaultTestConfig.class, loader = AnnotationConfigContextLoader.class)
public class ProcessorTest {

	private MessageData messageData = MessageData.newInstance(MessageData.MESSAGES_JSON);

	@Autowired
	Processor processor;

	@Test
	public void test() {
		for (Message message : this.messageData.getMessages()) {
			Message processedMessage = this.processor.toUpper(message);
			assertEquals("ID values not equal", message.getId(), processedMessage.getId());
			assertEquals("Name values not equal", message.getName().toUpperCase(), processedMessage.getName());
		}
	}
}
