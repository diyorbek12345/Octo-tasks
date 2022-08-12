package com.octo.json_test.sms.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.octo.json_test.sms.dto.Sms;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessagesDto {

    private String recipient;

    private String message_id;

    private String priority;

    private Sms sms;

}
