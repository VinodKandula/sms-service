package com.ubs.smsservice.smsserviceprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Service
public class TwilioSmsServiceProvider implements SmsServiceProvider {

    // Find your Account Sid and Token at twilio.com/console
    @Value("${twilio.ACCOUNT_SID}")
    private String ACCOUNT_SID;
    @Value("${twilio.AUTH_TOKEN}")
    private String AUTH_TOKEN;
    @Value("${twilio.PHONE_NUMBER}")
    private String from;

    @Override
    public void sendSms(String to, String body) {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(to),
                new PhoneNumber(from),
                body).create();

        System.out.println(message.getSid());

        System.out.println("sms sent " + ACCOUNT_SID);
    }

}
