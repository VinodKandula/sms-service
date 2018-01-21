package com.ubs.smsservice.smsserviceprovider;

import org.springframework.stereotype.Service;

@Service
public class TwilioSmsServiceProvider implements SmsServiceProvider {

    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "AC8af8fe0565035d36100a6eeb34aa5ce4";
    public static final String AUTH_TOKEN = "3bd4265016767b8185a95ecd5158032f";

    @Override
    public void sendSms() {
        /*
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber("+12012752759"),
                new PhoneNumber("+12017343425"),
                "This is the ship that made the Kessel Run in fourteen parsecs?").create();

        System.out.println(message.getSid());
        */
        System.out.println("sms sent");
    }
}
