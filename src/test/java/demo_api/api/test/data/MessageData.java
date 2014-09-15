package demo_api.api.test.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import demo_api.api.process.model.Message;

public class MessageData {

	List<Message> messages;

	@JsonCreator
	private MessageData(@JsonProperty("messages") List<Message> messages) {
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
