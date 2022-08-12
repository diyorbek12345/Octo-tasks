package com.octo.json_test.repository;

import com.octo.json_test.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long> {
    Message findByStatusAndType(String status, Integer type);
}
