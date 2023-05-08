package com.rak.reference.kafka.producer.service;

import com.rak.reference.kafka.producer.beans.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    KafkaTemplate<String, Item> kafkaTemplate;

    public void saveItem(Item item) {
        kafkaTemplate.send("test-topic", item);
    }
}
