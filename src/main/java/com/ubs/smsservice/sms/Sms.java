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
    @ApiModelProperty(value = "The database generated SMS ID",
            hidden=true)
    private Long id;

    @ApiModelProperty(value = "The phone number to where the SMS message should be sent to",
            example = "+12015551234",
            required=true,
            position=1)
    private String phoneNumber;

    @ApiModelProperty(value = "The body of the message for the SMS message",
            example = "Please response Yes or No.",
            position=2)
    private String body;

    @ApiModelProperty(value = "The response to this SMS message from the phone",
            allowEmptyValue=true,
            hidden=true)
    private String response="";

    @ApiModelProperty(value = "A requestNumber field that will later be sent back to the caller"
            , allowEmptyValue=true)
    private int requestNumber=0;

    @ApiModelProperty(value = "The URL to where the response will later be sent to",
            example = "http://example.com",
            allowEmptyValue=true)
    private String callbackUrl="";

    public Sms() {

    }


    public Sms(String phoneNumber, String body, int requestNumber, String callbackUrl) {
        super();
        this.phoneNumber = phoneNumber;
        this.body = body;
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
