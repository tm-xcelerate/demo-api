package demo_api.impl.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import demo_api.api.model.Message;

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

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", this.getId()).append("name", this.getName()).toString();
	}
}
