package com.codestates.hello_world.MessageDto;

import lombok.*;

@Getter
@Setter
public class MessageResponseDto {
    private long messageId;
    private String message;
}