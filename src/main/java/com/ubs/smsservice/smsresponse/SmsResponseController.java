package com.ubs.smsservice.smsresponse;

import com.ubs.smsservice.sms.Sms;
import com.ubs.smsservice.sms.SmsService;
import com.ubs.smsservice.smsserviceprovider.SmsServiceProvider;
//import com.ubs.smsservice.util.TwiMLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiMLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class SmsResponseController {

    @Autowired
    SmsService smsService;

    @Autowired
    SmsServiceProvider smsServiceProvider;

    public SmsResponseController() {
    }

    @RequestMapping(value = "/smsResponses", method = RequestMethod.POST, produces = "application/xml")
    public void smsResponse(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String phone = request.getParameter("From");
        String smsContent = request.getParameter("Body");


        System.out.println(request.toString());

        PrintWriter responseWriter = response.getWriter();

        //@RequestParam(value = "From", required = false) String phone;
//      @RequestParam(value = "Body", required = false) String smsContent;

        //String smsResponseText = "Sorry, it looks like you don't have any messages to respond to.";

        System.out.println("phone: " + phone);
        System.out.println("smsContent: " + smsContent);
        List<Sms> smsList = smsService.findByPhoneNumber(phone);
        System.out.println("found items: " + smsList.toString());
        /*
        Reservation reservation = reservationRepository.findFirstPendantReservationsByUser(user.getId());
        if (reservation != null) {
            if (smsContent.contains("yes") || smsContent.contains("accept"))
                reservation.confirm();
            else
                reservation.reject();
            reservationRepository.update(reservation);

            smsResponseText = String.format("You have successfully %s the reservation", reservation.getStatus().toString());
            smsNotifier.notifyGuest(reservation);
        }
*/
        //String message = "Thank you for confirming. Good Bye.";
/*
        try {
            Message sms = new Message.Builder()
                    .body(new Body("Hello, Mobile Monkey"))
                    .build();
            MessagingResponse twiml = new MessagingResponse
                    .Builder()
                    .message(sms)
                    .build();
        } catch (TwiMLException e) {
            e.printStackTrace();
        }

        response.setContentType("application/xml");
        response.getWriter().print(twiml.toXml());*/

        /*String message = "test";

        // Create a TwiML response and add our friendly message.
        Message sms = new Message.Builder().body(new Body(message)).build();
        MessagingResponse twimlResponse = new MessagingResponse.Builder().message(sms).build();

        response.setContentType("application/xml");*/

        // send a response with no reply
        MessagingResponse twiml = new MessagingResponse.Builder().build();
        response.setContentType("application/xml");
        responseWriter.print(twiml.toXml());


        //response.setContentType("application/xml");
        //responseWriter.print(TwiMLUtil.messagingResponse(message));



        // call callbackurl with response
    }

}
