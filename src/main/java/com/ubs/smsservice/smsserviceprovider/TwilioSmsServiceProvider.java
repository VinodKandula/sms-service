package com.ubs.smsservice.smsserviceprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioSmsServiceProvider implements SmsServiceProvider {

    // Find your Account Sid and Token at twilio.com/user/account
    @Value("${twilio.ACCOUNT_SID}")
    private String ACCOUNT_SID;
    @Value("${twilio.AUTH_TOKEN}")
    private String AUTH_TOKEN;

    @Override
    public void sendSms() {
        /*
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber("+12012752759"),
                new PhoneNumber("+12017343425"),
                "This is the ship that made the Kessel Run in fourteen parsecs?").create();

        System.out.println(message.getSid());
        */
        System.out.println("sms sent " + ACCOUNT_SID);
    }
}
