package com.ubs.smsservice.sms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sms {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String phoneNumber;
    private String body;
    private String response;
    private int requestNumber;
    private String callbackUrl;

    public Sms() {

    }


    public Sms(String phoneNumber, String text, String response, int requestNumber, String callbackUrl) {
        super();
        this.phoneNumber = phoneNumber;
        this.body = body;
        this.response = response;
        this.requestNumber = requestNumber;
        this.callbackUrl = callbackUrl;
    }

    public Long getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBody() {
        return body;
    }

    public String getResponse() {
        return response;
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    @Override
    public String toString() {
        return "Sms{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", body='" + body + '\'' +
                ", response='" + response + '\'' +
                ", requestNumber=" + requestNumber +
                ", callbackUrl='" + callbackUrl + '\'' +
                '}';
    }
}
