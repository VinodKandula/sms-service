package com.ubs.smsservice.sms;

import com.ubs.smsservice.smsserviceprovider.SmsServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RepositoryRestController
public class SmsController {

    @Autowired
    SmsServiceProvider smsService;
/*
    @RequestMapping(value = "/smsRequests", method = RequestMethod.POST)
    public String smsRequest() {

        // save request
        //smsService.save();

        // send sms

        String to = "+12012752759";
        String body = "This is the ship that made the Kessel Run in fourteen parsecs?";

        smsService.sendSms(to, body);
        return "texts";
    }
*/
    /*@RequestMapping("/smsResponses")
    public String smsResponse() {

        // read response

        // find request in table

        // save response

        // call callbackurl with response

        return "texts";
    }*/

}
