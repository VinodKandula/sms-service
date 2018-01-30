package com.ubs.smsservice.smsserviceprovider;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.twiml.MessagingResponse;
import com.twilio.type.PhoneNumber;

class TwilioSmsServiceProvider implements SmsServiceProvider {

    // Find your Account Sid and Token at twilio.com/console
    private final String accountSid;
    private final String authToken;
    private final String from;

    TwilioSmsServiceProvider(String accountSid, String authToken, String from) {
        this.accountSid = accountSid;
        this.authToken = authToken;
        this.from = from;
    }

    @Override
    public void sendSms(String to, String body) {
        Twilio.init(this.accountSid, this.authToken);
        Message message = Message.creator(new PhoneNumber(to),
                new PhoneNumber(from),
                body).create();
        System.out.println(message.getSid());
        System.out.println("SMS sent: " + this.authToken);
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
