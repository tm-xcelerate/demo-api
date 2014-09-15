package demo_api.api.test.data;

import java.util.List;

import demo_api.api.process.model.Message;

public interface TestData {

	public static final String MESSAGES_JSON = "messages.json";

	List<Message> getMessages();

}
