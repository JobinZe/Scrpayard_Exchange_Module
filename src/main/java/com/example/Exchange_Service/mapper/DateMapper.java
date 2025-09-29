package com.example.Exchange_Service.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateMapper {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public LocalDateTime asLocalDateTime(String date){
        if (date == null || date.isEmpty()) {
            return null;
        }
        return LocalDateTime.parse(date);
    }
    public String asString(LocalDateTime date){
        if (date == null) {
            return null;
        }
        return date.format(FORMATTER);
    }
}
