package com.example.david_test.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * LocalDateAttributeConverter convert attirbut of type LocalDate to Date
 */
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate x) {
        if (x == null) {
            return null;
        } else {
            ZoneId defaultZoneId = ZoneId.systemDefault();
            return Date.from(x.atStartOfDay(defaultZoneId).toInstant());
        }

    }

    @Override
    public LocalDate convertToEntityAttribute(Date y) {
        return y == null ? null : y.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
