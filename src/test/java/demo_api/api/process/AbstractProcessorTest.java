package demo_api.api.process;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import demo_api.api.model.Message;
import demo_api.api.test.data.TestData;

public abstract class AbstractProcessorTest implements ProcessorTest {

	abstract protected TestData getTestData();

	abstract protected Processor getProcessor();

	@Override
	@Test
	public void testToUpper() {
		for (Message message : this.getTestData().getMessages()) {
			Message processedMessage = this.getProcessor().toUpper(message);
			assertEquals("ID values not equal", message.getId(), processedMessage.getId());
			assertEquals("Name values not equal", message.getName().toUpperCase(), processedMessage.getName());
		}
	}
}
