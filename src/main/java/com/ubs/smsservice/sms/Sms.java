package com.ubs.smsservice.sms;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sms {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated SMS ID")
    private Long id;

    @ApiModelProperty(notes = "The phone number to where the SMS message should be sent to")
    private String phoneNumber;

    @ApiModelProperty(notes = "The body of the message for the SMS message")
    private String body;

    @ApiModelProperty(notes = "The response to this SMS message from the phone")
    private String response;

    @ApiModelProperty(notes = "A requestNumber field that will later be sent back to the caller")
    private int requestNumber;

    @ApiModelProperty(notes = "The URL to where the response will later be sent to")
    private String callbackUrl;

    public Sms() {

    }


    public Sms(String phoneNumber, String body, String response, int requestNumber, String callbackUrl) {
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

    public void setResponse(String response) {
        this.response = response;
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
