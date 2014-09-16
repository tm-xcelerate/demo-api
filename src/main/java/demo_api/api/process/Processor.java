package demo_api.api.process;

import demo_api.api.model.Message;

public interface Processor {

	Message toUpper(Message message);
}
