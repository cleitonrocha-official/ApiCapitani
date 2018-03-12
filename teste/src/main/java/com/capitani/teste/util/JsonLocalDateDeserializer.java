package com.capitani.teste.util;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JsonLocalDateDeserializer extends JsonDeserializer<LocalDate> {

	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return LocalDate.parse(p.getText(), LocalDateFormatter.getFormat());
	}
	
}


