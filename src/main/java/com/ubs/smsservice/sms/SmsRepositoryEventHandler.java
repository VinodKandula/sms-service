package com.ubs.smsservice.sms;

import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler(Sms.class)
public class SmsRepositoryEventHandler {

    @HandleAfterCreate
    public void handleSmsCreate(Sms sms) {
        System.out.println("handled!" + sms.toString());

    }

}
