package com.capitani.teste;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.capitani.teste.util.JsonLocalDateDeserializer;
import com.capitani.teste.util.JsonLocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Configuration
public class ApplicationConfiguration {

	/*
	 * Configuração do Bean de serialização e deserialização de JSON e XML
	 */
	@Bean
	public Jackson2ObjectMapperBuilder objctMapperBuilder() {
		return new Jackson2ObjectMapperBuilder().deserializerByType(LocalDate.class, new JsonLocalDateDeserializer())
				.serializerByType(LocalDate.class, new JsonLocalDateSerializer())
				.serializationInclusion(Include.NON_NULL);

	}

}
