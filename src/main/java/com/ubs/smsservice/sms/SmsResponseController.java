package com.ubs.smsservice.sms;

import com.ubs.smsservice.smsserviceprovider.SmsServiceProvider;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Api(description="Operations pertaining to SMS Responses")
class SmsResponseController {

    private final SmsServiceProvider smsServiceProvider;
    private final SmsCallbackExecutor executor;

    private static final Logger log = LoggerFactory.getLogger(SmsResponseController.class);


    public SmsResponseController(final SmsServiceProvider smsServiceProvider,
            SmsCallbackExecutor executor) {
        this.smsServiceProvider = smsServiceProvider;
        this.executor = executor;
    }

    @RequestMapping(value = "smsResponses", method = RequestMethod.POST, produces = "application/xml")
    public void smsResponse(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String phone = request.getParameter("From");
        String smsContent = request.getParameter("Body");
        log.info("Request received: {}", request.toString());
        this.executor.executeCallbackIfSmsPresent(phone, smsContent);
        // Send a empty response back to the SMS provider
        this.smsServiceProvider.sendResponse(response, "");
    }

}
