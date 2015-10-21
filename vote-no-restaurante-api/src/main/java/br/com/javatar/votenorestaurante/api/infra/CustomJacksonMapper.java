package br.com.javatar.votenorestaurante.api.infra;

import java.util.Locale;
import java.util.TimeZone;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

/**
 * The Class CustomJacksonMapper.
 */
@Component("customJacksonMapper")
public class CustomJacksonMapper extends ObjectMapper {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new custom jackson mapper.
	 * 
	 * RegisterModule = Registar o módulo do JodaTime.
	 * Locale = Padrão portugues Brasil.
	 * TimeZone = Converte para o timezone de São Paulo.
	 * 
	 */
	public CustomJacksonMapper() {
        this.registerModule(new JodaModule());
        this.setLocale(new Locale("pt_BR"));
        this.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
        this.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS , false);
        this.setSerializationInclusion(JsonInclude.Include.ALWAYS);
	}

}
