package com.codestates.hello_world.Message;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class Message {
    @Id
    private long messageId;
    private String message;
}
