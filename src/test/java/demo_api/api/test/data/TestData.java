package demo_api.api.test.data;

import java.util.List;

import demo_api.api.model.Message;

public interface TestData {

	public static final String MESSAGES_JSON = "messages.json";

	List<Message> getMessages();

}
