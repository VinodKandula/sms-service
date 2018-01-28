package com.ubs.smsservice.smsserviceprovider;

import com.twilio.twiml.MessagingResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


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
        System.out.println("SMS sent: " + ACCOUNT_SID);
    }




    @Override
    public void sendResponse(HttpServletResponse response, String body) throws IOException {

        PrintWriter responseWriter = response.getWriter();

        // send a response to twilio with no reply
        MessagingResponse twiml = new MessagingResponse.Builder().build();
        response.setContentType("application/xml");
        responseWriter.print(twiml.toXml());
    }
}
