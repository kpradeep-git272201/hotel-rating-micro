package com.hotel.HotelService.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hotel.HotelService.dtos.HotelDTOs;
import com.hotel.HotelService.entities.Hotels;
import org.springframework.stereotype.Component;

@Component
public class CustomObjectMapper {
    private final ObjectMapper objectMapper;
    public CustomObjectMapper() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.findAndRegisterModules();
        this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public <T> T convert(Object source, Class<T> targetClass) {
        return objectMapper.convertValue(source, targetClass);
    }
    public ObjectMapper objectMapper(Hotels hotels, Class<HotelDTOs> hotelDTOsClass) {
        return objectMapper;
    }
}

