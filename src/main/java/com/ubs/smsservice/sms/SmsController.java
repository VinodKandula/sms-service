package com.ubs.smsservice.sms;

import com.ubs.smsservice.smsserviceprovider.SmsServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SmsController {

    @Autowired
    SmsServiceProvider smsService;

    @RequestMapping("/greeting")
    public String greeting() {
        smsService.sendSms();
        return "texts";
    }

}
