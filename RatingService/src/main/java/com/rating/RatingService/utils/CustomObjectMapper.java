package com.rating.RatingService.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rating.RatingService.dtos.RatingDTOs;
import com.rating.RatingService.entities.Rating;
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
    public ObjectMapper objectMapper(Rating rating, Class<RatingDTOs> ratingDTOsClass) {
        return objectMapper;
    }
}
