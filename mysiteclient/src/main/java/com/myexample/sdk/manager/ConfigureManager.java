package com.myexample.sdk.manager;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myexample.sdk.Config;

public abstract class ConfigureManager {
	private ObjectMapper objectMapper;

	public ConfigureManager() {
		Config.init();
	}

	public ObjectMapper getObjectMapper() {
		this.objectMapper = new ObjectMapper();
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}
}
