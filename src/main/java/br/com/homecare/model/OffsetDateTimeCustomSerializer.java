package br.com.homecare.model;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;

public class OffsetDateTimeCustomSerializer extends OffsetDateTimeSerializer {

	private static final long serialVersionUID = 1L;

	@Override
	public void serialize(OffsetDateTime offsetDateTime, JsonGenerator generator, SerializerProvider provider)
			throws IOException {

		generator.writeString(offsetDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
	}

}
