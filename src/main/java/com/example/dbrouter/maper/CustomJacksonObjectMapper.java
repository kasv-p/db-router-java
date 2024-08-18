package com.example.dbrouter.maper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.format.DateTimeFormatter;

@Configuration
public class CustomJacksonObjectMapper {
    @Bean(name = "customJacksonObjectMapperBuilder")
    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
        String DATETIME_FORMAT = "dd-MM-yyyy HH:mm";
        return new Jackson2ObjectMapperBuilder().serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT)))
                .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .serializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
