package com.rak.reference.kafka.producer.beans;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private Long id;
    private String key;
    private String name;
}
