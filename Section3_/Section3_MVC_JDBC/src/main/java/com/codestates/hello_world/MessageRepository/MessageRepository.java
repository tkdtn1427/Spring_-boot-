package com.codestates.hello_world.MessageRepository;

import com.codestates.hello_world.Message.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
