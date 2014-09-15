package demo_api.api.test.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import demo_api.api.process.model.Message;

public class DefaultTestData implements TestData {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(DefaultTestData.class);

	private static DefaultTestData instance;

	@Autowired
	private ObjectMapper objectMapper;

	private MessageData messageData;

	private DefaultTestData() {
		super();
	}

	public static DefaultTestData getInstance() {
		if (instance == null) {
			instance = new DefaultTestData();
		}
		return instance;
	}

	public void loadMessages(String fileName) {
		try {
			// read json file data to InputStream
			InputStream jsonDataStream = DefaultTestData.class.getClassLoader().getResourceAsStream(fileName);

			// convert json string to object
			messageData = this.objectMapper.readValue(jsonDataStream, MessageData.class);

			logger.debug("Loaded Message Data:\n" + this.messageData.toString());
		} catch (IOException e) {
			logger.error("IOException caught in MessageData.newInstance()", e);
		}
	}

	@Override
	public List<Message> getMessages() {
		if (this.messageData == null) {
			this.loadMessages(TestData.MESSAGES_JSON);
		}
		return this.messageData.getMessages();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("{");
		stringBuilder.append(this.messageData.toString());
		return stringBuilder.append("}").toString();
	}
}
