package com.capitani.teste.util;

import java.io.IOException;

import com.capitani.teste.entities.Cliente;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.LongNode;

public class ClienteDeserializer extends JsonDeserializer<Cliente> {

	@Override
	public Cliente deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		 JsonNode node = jp.getCodec().readTree(jp);
		 System.out.println(node);
		
		return new Cliente(node.longValue(),"");
	}
	
}


