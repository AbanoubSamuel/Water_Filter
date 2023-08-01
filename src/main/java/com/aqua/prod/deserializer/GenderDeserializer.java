package com.aqua.prod.deserializer;

import com.aqua.prod.entity.Gender;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;


@JsonComponent
public class GenderDeserializer extends JsonDeserializer<Gender> {

    @Override
    public Gender deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException
    {
        int genderId = jsonParser.getValueAsInt();
        // Create a new Gender instance using the genderId
        Gender gender = new Gender();
        gender.setId(genderId);
        // Return the newly created Gender instance
        return gender;
    }
}
