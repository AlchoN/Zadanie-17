package com.example.demo.controller;

import com.example.demo.dto.Message;
import com.example.demo.repository.MessageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person/{p_id}/message")
public class MessageController {
    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping
    public List<Message> getAllMessages(@PathVariable int p_id) {
        return messageRepository.findAll();
    }

    @GetMapping("/{m_id}")
    public ResponseEntity<Message> getMessageById(@PathVariable int p_id, @PathVariable int m_id) {
        Message message = messageRepository.findById(m_id);
        return message != null ? ResponseEntity.ok(message) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Message createMessage(@PathVariable int p_id, @RequestBody Message message) {
        return messageRepository.save(message);
    }

    @DeleteMapping("/{m_id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int p_id, @PathVariable int m_id) {
        return messageRepository.deleteById(m_id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}