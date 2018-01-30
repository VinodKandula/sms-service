package com.ubs.smsservice.sms;

import com.ubs.smsservice.smsserviceprovider.SmsServiceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler(SmsEntity.class)
class SmsRepositoryEventHandler {

    private final SmsServiceProvider smsService;

    private static final Logger log = LoggerFactory.getLogger(SmsRepositoryEventHandler.class);

    SmsRepositoryEventHandler(SmsServiceProvider smsService) {
        this.smsService = smsService;
    }

    @HandleAfterCreate
    public void handleSmsCreate(SmsEntity sms) {
        log.info("Sending sms: {}", sms.toString());
        smsService.sendSms(sms.getPhoneNumber(),sms.getBody());
    }

}
