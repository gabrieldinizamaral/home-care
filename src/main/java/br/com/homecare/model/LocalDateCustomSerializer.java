package br.com.homecare.model;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class LocalDateCustomSerializer extends LocalDateSerializer {

	private static final long serialVersionUID = 1L;

    @Override
    public void serialize(LocalDate localDate, JsonGenerator generator, SerializerProvider provider)
        throws IOException {
        generator.writeString(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));

    }

}
