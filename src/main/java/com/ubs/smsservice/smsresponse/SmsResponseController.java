package com.ubs.smsservice.smsresponse;

import com.ubs.smsservice.sms.Sms;
import com.ubs.smsservice.sms.SmsService;
import com.ubs.smsservice.smsserviceprovider.SmsServiceProvider;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
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
        sms.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        smsService.smsRepo.save(sms);
        System.out.println("Saved: "+sms.toString());

        // Send a empty response back to the SMS provider
        smsServiceProvider.sendResponse(response, "");

        // call callbackurl to sms object
        ResponseEntity<String> result = this.postToCallbackUrl(sms.getCallbackUrl(), sms);
        System.out.println(result);
    }

    private ResponseEntity<String> postToCallbackUrl (final String url, Object obj) {

        //set your headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //set your entity to send
        HttpEntity entity = new HttpEntity(obj,headers);

        //send it!
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> out = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return out;
    }

}
