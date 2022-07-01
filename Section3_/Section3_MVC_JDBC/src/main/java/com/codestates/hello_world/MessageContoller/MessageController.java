package com.codestates.hello_world.MessageContoller;

import com.codestates.hello_world.Message.Message;
import com.codestates.hello_world.MessageDto.MessagePostDto;
import com.codestates.hello_world.MessageMapper.MessageMapper;
import com.codestates.hello_world.MessageService.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/v1/messages")
@RestController
public class MessageController {
    private final MessageService messageService;
    private final MessageMapper mapper;

    public MessageController(MessageService messageService,
                             MessageMapper mapper){
        this.messageService = messageService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postMessage(@Valid @RequestBody MessagePostDto messagePostDto){
        Message message = messageService.createMessage(mapper.messageDtoToMessage(messagePostDto));

        return ResponseEntity.ok(mapper.messageToMessageResponseDto(message));
    }
}
