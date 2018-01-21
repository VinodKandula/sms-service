package com.ubs.smsservice;

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
    private String text;
    private String response;
    private int requestNumber;
    private String callbackUrl;

    public Sms() {

    }


    public Sms(String phoneNumber, String text, String response, int requestNumber, String callbackUrl) {
        super();
        this.phoneNumber = phoneNumber;
        this.text = text;
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

    public String getText() {
        return text;
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
                ", text='" + text + '\'' +
                ", response='" + response + '\'' +
                ", requestNumber=" + requestNumber +
                ", callbackUrl='" + callbackUrl + '\'' +
                '}';
    }
}
