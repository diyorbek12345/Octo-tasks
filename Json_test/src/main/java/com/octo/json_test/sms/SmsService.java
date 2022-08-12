package com.octo.json_test.sms;

import com.octo.json_test.entity.Message;
import com.octo.json_test.repository.MessagesRepo;
import com.octo.json_test.sms.dto.Messages;
import com.octo.json_test.sms.dto.SendReply;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@EnableScheduling
@Slf4j
public class SmsService {



    @Value("${smsgate.sender:16888}")
    private String senderName;

    @Value("${smsgate.login:1234}")
    private String login;

    @Value("${smsgate.key:1234}")
    private String secretKey;

    @Autowired
    MessagesRepo messagesRepo;

    public SendReply addSMSTest(List<Messages> message) {
        SendReply reply = new SendReply();
        reply.setMessages(
               message
        );
        return reply;
    }

    public List<?> getSMS() {
       return messagesRepo.findAll();
    }

    public SendReply sendSMS(Message message) {
        if (message.getDestAddress() == null || message.getDestAddress().length() < 10) {
            log.warn("invalid phone: " + message.getDestAddress());
            return null;
        }
        if (message.getSourceAddress().equals("NOTIF")) {
            log.info("SMS to " + message.getDestAddress());


            RestTemplate restTemplate = new RestTemplate();
            Map<String, Object> vars = initBaseMap();
            if (vars.size() != 10 ) {
                vars.put("sender", senderName);
                vars.put("phone", message.getDestAddress());
                vars.put("text", message.getText());
            }
            try {
             SendReply rv =objectMap(vars,restTemplate);
            vars.clear();
                return rv;
            } catch (Exception e) {
                log.error("Error sending SMS", e);
            }
        }
        log.error("Error sending SMS");
        return null;
    }

//    @Scheduled(cron = "*/10 * * * * *")
    public SendReply objectMap(Map<String, Object> vars,RestTemplate restTemplate) {
        SendReply rv = null;
        if (vars.size() != 10) {
        }
            rv = restTemplate.postForObject(composeURL("http://91.204.239.44/broker-api/send", vars), null, SendReply.class);
        return rv;
    }


    public SendReply sendSMS3ds(Message message) {
        if (message.getDestAddress() == null || message.getDestAddress().length() < 10) {
            log.warn("invalid phone: " + message.getDestAddress());
            return null;
        }

            log.info("SMS to " + message.getDestAddress());


            RestTemplate restTemplate = new RestTemplate();
            try {
                SendReply rv = restTemplate.postForObject("http://91.204.239.44/broker-api/send", null, SendReply.class);
                return rv;
            } catch (Exception e) {
                log.error("Errorr sending SMS", e);
            }
        log.error("Error sending SMS");
        return null;
    }


    private String composeURL(String urlBase, Map<String, Object> params) {
        StringBuilder rv = new StringBuilder(urlBase);
        int cnt = 0;
        if (params != null) {
            for (String key : params.keySet()) {
                if (cnt == 0)
                    rv.append("?");
                else
                    rv.append("&");
                rv.append(key).append("={").append(key).append("}");
                cnt++;
            }
        }
        return rv.toString();
    }

    private Map<String, Object> initBaseMap() {
        log.info("> initBaseMap : login = " + login + ", key = " + secretKey);
        Map<String, Object> vars = new HashMap<>();
        vars.put("login", login);
        vars.put("key", secretKey);
        return vars;
    }


}
