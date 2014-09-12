package demo_api.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo_api.api.process.model.Message;

public class MessageData {

	List<Message> messages;

	@JsonCreator
	public MessageData(@JsonProperty("messages") List<Message> messages) {
		super();
		this.messages = messages;
	}

	public static MessageData newInstance() {
		try {
			// create ObjectMapper instance
			ObjectMapper objectMapper = new ObjectMapper();

			MessageData messageData = createMessageData(objectMapper);

			System.out.println("Message Data Object\n" + messageData);
			return messageData;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private static MessageData createMessageData(ObjectMapper objectMapper) throws IOException {
		// read json file data to InputStream
		InputStream jsonDataStream = MessageData.class.getClassLoader().getResourceAsStream("messages.json");

		// convert json string to object
		return objectMapper.readValue(jsonDataStream, MessageData.class);
	}

	public List<Message> getMessages() {
		if (this.messages == null) {
			this.messages = new ArrayList<Message>();
		}
		return this.messages;
	}
}
