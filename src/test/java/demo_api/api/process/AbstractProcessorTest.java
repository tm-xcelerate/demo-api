package demo_api.api.process;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import demo_api.api.process.model.Message;
import demo_api.api.test.data.TestData;

public abstract class AbstractProcessorTest implements ProcessorTest {

	@Autowired
	TestData testData;

	@Autowired
	Processor processor;

	@Test
	public void testToUpper() {
		for (Message message : this.testData.getMessages()) {
			Message processedMessage = this.processor.toUpper(message);
			assertEquals("ID values not equal", message.getId(), processedMessage.getId());
			assertEquals("Name values not equal", message.getName().toUpperCase(), processedMessage.getName());
		}
	}
}
