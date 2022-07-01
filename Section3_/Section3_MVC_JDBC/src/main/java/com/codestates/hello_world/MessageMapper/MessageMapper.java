package com.codestates.hello_world.MessageMapper;

import com.codestates.hello_world.Message.Message;
import com.codestates.hello_world.MessageDto.MessagePostDto;
import com.codestates.hello_world.MessageDto.MessageResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message messageDtoToMessage(MessagePostDto messagePostDto);
    MessageResponseDto messageToMessageResponseDto(Message message);
}
