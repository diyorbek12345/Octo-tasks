package com.octo.json_test.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class SmsController {

    @Autowired
    SmsService smsService;

    private static final Logger log = LoggerFactory.getLogger(SmsController.class);

    @GetMapping
    public List<?> getList() {
        log.info("< get");
        return smsService.getSMS();
    }
}
