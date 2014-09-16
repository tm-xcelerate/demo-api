package demo_api.impl.test.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import demo_api.api.model.Message;
import demo_api.api.test.data.TestData;

public class DefaultTestData implements TestData {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(DefaultTestData.class);

	@Autowired
	private ObjectMapper objectMapper;

	private MessageData messageData;

	public DefaultTestData() {
		super();
	}

	@Override
	public List<Message> getMessages() {
		if (this.messageData == null) {
			this.loadMessages();
		}
		return this.messageData.getMessages();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("{");
		stringBuilder.append(this.messageData.toString());
		return stringBuilder.append("}").toString();
	}

	private ClassLoader getClassLoader() {
		return DefaultTestData.class.getClassLoader();
	}

	private void loadMessages() {
		try {
			// convert json string to object
			this.messageData = MessageData.instantiate(this.objectMapper,
					this.getClassLoader().getResourceAsStream(TestData.MESSAGES_JSON));

			logger.debug("Loaded Message Data:\n" + this.messageData.toString());
		} catch (IOException e) {
			logger.error("IOException caught in MessageData.newInstance()", e);
			this.messageData = new MessageData(new ArrayList<Message>());
		}
	}
}
