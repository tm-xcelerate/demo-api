package demo_api.api.test.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo_api.api.process.model.Message;

public class MessageData {

	public static final String MESSAGES_JSON = "messages.json";

	List<Message> messages;

	@JsonCreator
	public MessageData(@JsonProperty("messages") List<Message> messages) {
		super();
		this.messages = messages;
	}

	public static MessageData newInstance(String fileName) {
		try {
			// create ObjectMapper instance
			ObjectMapper objectMapper = new ObjectMapper();

			// read json file data to InputStream
			InputStream jsonDataStream = MessageData.class.getClassLoader().getResourceAsStream(fileName);

			// convert json string to object
			MessageData messageData = objectMapper.readValue(jsonDataStream, MessageData.class);

			System.out.println("Message Data Object\n" + messageData);
			return messageData;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<Message> getMessages() {
		if (this.messages == null) {
			this.messages = new ArrayList<Message>();
		}
		return this.messages;
	}
}
