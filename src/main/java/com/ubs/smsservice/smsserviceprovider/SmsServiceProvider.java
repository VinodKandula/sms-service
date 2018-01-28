package com.ubs.smsservice.smsserviceprovider;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface SmsServiceProvider {

    void sendSms(String to, String body);

    void sendResponse(HttpServletResponse response, String body) throws IOException;

}
