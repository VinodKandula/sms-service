package com.ubs.smsservice.sms;

import com.ubs.smsservice.smsserviceprovider.SmsServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler(Sms.class)
public class SmsRepositoryEventHandler {

    @Autowired
    SmsServiceProvider smsService;

    @HandleAfterCreate
    public void handleSmsCreate(Sms sms) {
        System.out.println("Sending sms: "+ sms.toString());

        smsService.sendSms(sms.getPhoneNumber(),sms.getBody());

    }

}
