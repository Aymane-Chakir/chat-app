package net.aymane.messageservice.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.aymane.messageservice.entity.Message;
import net.aymane.messageservice.repository.MessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MessageController {
    private final MessageRepository messageRepository;
    @GetMapping("/messages")
    public List<Message> getAllMessage(){
        return messageRepository.findAll();
    };
}
