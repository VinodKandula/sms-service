package com.ubs.smsservice.smsserviceprovider;

public interface SmsServiceProvider {

    void sendSms(String to, String body);
}
