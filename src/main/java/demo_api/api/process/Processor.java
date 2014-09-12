package demo_api.api.process;

import demo_api.api.process.model.Message;

public interface Processor {

	Message toUpper(Message message);
}
