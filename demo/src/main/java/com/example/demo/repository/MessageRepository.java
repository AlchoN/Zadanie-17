package com.example.demo.repository;

import com.example.demo.dto.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {
    private List<Message> messages = new ArrayList<>();
    private int currentId = 0;

    public List<Message> findAll() {
        return messages;
    }

    public Message findById(int id) {
        return messages.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    public Message save(Message message) {
        message.setId(++currentId);
        messages.add(message);
        return message;
    }

    public boolean deleteById(int id) {
        return messages.removeIf(message -> message.getId() == id);
    }
}