package com.bbb.restfulapiexample.utils;

import javax.persistence.AttributeConverter;
import java.time.LocalDate;
import java.util.Date;

public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return java.sql.Date.valueOf(localDate);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
        if (sqlDate == null) return null;
        return LocalDate.from(sqlDate.toInstant());
    }
}
