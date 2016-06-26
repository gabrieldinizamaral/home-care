package br.com.homecare.model;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OffsetDateTimePersistenceConverter implements AttributeConverter<OffsetDateTime, Date> {

	@Override
	public Date convertToDatabaseColumn(OffsetDateTime entityValue) {
		return Date.from(entityValue.toInstant());
	}

	@Override
	public OffsetDateTime convertToEntityAttribute(Date databaseValue) {
		return OffsetDateTime.ofInstant(databaseValue.toInstant(), ZoneOffset.UTC);
	}

}
