package demo_api.impl.test.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo_api.api.process.model.Message;

public class MessageData {

	public static MessageData instantiate(ObjectMapper objectMapper, InputStream jsonDataStream)
			throws JsonParseException, JsonMappingException, IOException {
		return objectMapper.readValue(jsonDataStream, MessageData.class);
	}

	List<Message> messages;

	@JsonCreator
	public MessageData(@JsonProperty("messages") List<Message> messages) {
		super();
		this.messages = messages;
	}

	public List<Message> getMessages() {
		if (this.messages == null) {
			this.messages = new ArrayList<Message>();
		}
		return this.messages;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("messages", this.getMessages()).toString();
	}
}
