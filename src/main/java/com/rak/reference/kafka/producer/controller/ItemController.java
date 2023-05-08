package com.rak.reference.kafka.producer.controller;

import com.rak.reference.kafka.producer.beans.Item;
import com.rak.reference.kafka.producer.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/save")
    public void saveItem(@RequestBody Item item) {
        itemService.saveItem(item);
    }
}
