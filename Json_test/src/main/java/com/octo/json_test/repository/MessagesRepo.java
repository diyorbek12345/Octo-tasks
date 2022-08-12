package com.octo.json_test.repository;

import com.octo.json_test.sms.dto.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessagesRepo extends JpaRepository<Messages, Long> {

}
