package com.rak.reference.kafka.producer.beans.serializer;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rak.reference.kafka.producer.beans.Item;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class ItemSerializer extends JsonSerializer<Item> implements Serializer<Item> {

    Logger log = LoggerFactory.getLogger(ItemSerializer.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> config, boolean isKey) {
        super.configure(config, isKey);
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public byte[] serialize(String topic, Item data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            log.info("Error in serializing the object", data);
            throw new RuntimeException("Error serializing MyMessage object: " + e.getMessage(), e);
        }
    }
}
