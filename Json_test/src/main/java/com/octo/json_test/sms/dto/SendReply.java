package com.octo.json_test.sms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class SendReply {
    private List<Messages> messages;

//    public SendReply(String recipient, String message_id, String priority, Sms sms){
//        this.messages = (List<Messages>) new Messages(recipient, message_id, priority, sms);
//    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

    @Override
    public String toString(){
        return "SendReply{" +
                "messages=" + messages +
                "}";
    }

}
