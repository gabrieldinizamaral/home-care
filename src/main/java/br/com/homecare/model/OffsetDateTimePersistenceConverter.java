package br.com.homecare.model;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OffsetDateTimePersistenceConverter implements AttributeConverter<OffsetDateTime, String> {

	@Override
	public String convertToDatabaseColumn(OffsetDateTime entityValue) {
		return Timestamp.valueOf(entityValue.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()).toString();
	}

	@Override
	public OffsetDateTime convertToEntityAttribute(String databaseValue) {
		return OffsetDateTime.parse(databaseValue);
	}

}
