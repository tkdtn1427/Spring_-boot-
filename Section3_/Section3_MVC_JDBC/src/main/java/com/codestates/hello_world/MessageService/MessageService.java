package com.codestates.hello_world.MessageService;

import com.codestates.hello_world.Message.Message;
import com.codestates.hello_world.MessageRepository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public Message createMessage(Message message){
        return messageRepository.save(message);
    }
}
