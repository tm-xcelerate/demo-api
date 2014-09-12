package demo_api.impl.process.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import demo_api.api.process.model.Message;

public final class DefaultMessage implements Message {

	private final Integer id;
	private final String name;

	@JsonCreator
	public DefaultMessage(@JsonProperty("id") Integer id, @JsonProperty("name") String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public String getName() {
		return this.name;
	}
}
