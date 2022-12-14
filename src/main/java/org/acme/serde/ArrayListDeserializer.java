package org.acme.serde;

import alpine.model.ConfigProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.acme.model.Component;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.ArrayList;

public class ArrayListDeserializer implements Deserializer<ArrayList<Component>> {

    @Override
    public ArrayList<Component> deserialize(String topic, byte[] bytes) {
        try {
            ArrayList<Component> myObjects = new ObjectMapper().readValue(bytes, new TypeReference<ArrayList<Component>>(){});
            return myObjects;
        } catch (Exception e) {
            throw new SerializationException(e);
        }
    }
}
