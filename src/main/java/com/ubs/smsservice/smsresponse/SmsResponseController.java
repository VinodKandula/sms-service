package com.ubs.smsservice.smsresponse;

import com.ubs.smsservice.sms.Sms;
import com.ubs.smsservice.sms.SmsService;
import com.ubs.smsservice.smsserviceprovider.SmsServiceProvider;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Api(description="Operations pertaining to SMS Responses")
public class SmsResponseController {

    @Autowired
    SmsService smsService;

    @Autowired
    SmsServiceProvider smsServiceProvider;

    public SmsResponseController() {
    }

    @RequestMapping(value = "smsResponses", method = RequestMethod.POST, produces = "application/xml")
    public void smsResponse(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String phone = request.getParameter("From");
        String smsContent = request.getParameter("Body");
        System.out.println(request.toString());

        System.out.println("phone: " + phone);
        System.out.println("smsContent: " + smsContent);
        List<Sms> smsList = smsService.findByPhoneNumber(phone);
        System.out.println("found items: " + smsList.toString());

        // We will get the last match, in case there is more than one match
        // The assumption is that it is the most recent
        Sms sms = smsList.get(smsList.size() - 1);

        // save the sms response into the repository
        sms.setResponse(smsContent);
        smsService.smsRepo.save(sms);
        System.out.println("Saved: "+sms.toString());

        // Send a empty response back to the SMS provider
        smsServiceProvider.sendResponse(response, "");

        // call callbackurl to sms object
        Sms result = this.postToCallbackUrl(sms.getCallbackUrl(), sms);
        System.out.println(result);
    }

    private Sms postToCallbackUrl (final String uri, Sms sms) {

        RestTemplate restTemplate = new RestTemplate();
        Sms result = restTemplate.postForObject( uri, sms, Sms.class);

        return result;
    }

}
