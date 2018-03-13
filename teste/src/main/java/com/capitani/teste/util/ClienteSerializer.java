package com.capitani.teste.util;

import java.io.IOException;

import com.capitani.teste.entities.Cliente;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ClienteSerializer extends JsonSerializer<Cliente> {

	public void serialize(Cliente value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeNumber(value == null ? null : value.getCodigoCliente());

	}

}
