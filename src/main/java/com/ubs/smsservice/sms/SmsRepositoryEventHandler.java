package com.ubs.smsservice.sms;

import com.ubs.smsservice.smsserviceprovider.SmsServiceProvider;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler(SmsEntity.class)
class SmsRepositoryEventHandler {

    private final SmsServiceProvider smsService;

    SmsRepositoryEventHandler(SmsServiceProvider smsService) {
        this.smsService = smsService;
    }

    @HandleAfterCreate
    public void handleSmsCreate(SmsEntity sms) {
        System.out.println("Sending sms: "+ sms.toString());
        smsService.sendSms(sms.getPhoneNumber(),sms.getBody());
    }

}
