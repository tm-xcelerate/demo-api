package demo_api.impl.process;

import demo_api.api.model.Message;
import demo_api.api.process.Processor;
import demo_api.impl.model.DefaultMessage;

public class DefaultProcessor implements Processor {

	@Override
	public Message toUpper(Message message) {
		return new DefaultMessage(message.getId(), message.getName().toUpperCase());
	}

}
