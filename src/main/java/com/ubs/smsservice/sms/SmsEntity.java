package com.ubs.smsservice.sms;

import java.sql.Timestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name="sms")
class SmsEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ApiModelProperty(value = "The database generated SMS ID")
    private Long id;

    @NotNull
    @ApiModelProperty(value = "The phone number to where the SMS message should be sent to",
            example = "+12015551234",
            required=true)
    private String phoneNumber;

    @NotNull
    @ApiModelProperty(value = "The body of the message for the SMS message",
            example = "Please response Yes or No.",
            position = 2)
    private String body;

    @ApiModelProperty(value = "The response to this SMS message from the phone",
            allowEmptyValue=true)
    private String response="";

    @ApiModelProperty(value = "A requestNumber field that will later be sent back to the caller",
            allowEmptyValue=true,
            example="0",
            position = 3)
    private int requestNumber=0;

    @ApiModelProperty(value = "The URL to where the response will later be sent to",
            example = "http://example.com",
            allowEmptyValue=true,
            position = 4)
    private String callbackUrl="";

    @Column(updatable=false, nullable = false)
    @CreatedDate
    @ApiModelProperty(hidden = true)
    private Timestamp createdDate = new Timestamp(System.currentTimeMillis());

    @LastModifiedDate
    @ApiModelProperty(hidden = true)
    private Timestamp modifiedDate = new Timestamp(System.currentTimeMillis());

    public SmsEntity() {

    }

    public SmsEntity(String phoneNumber, String body, int requestNumber, String callbackUrl) {
        super();
        this.phoneNumber = phoneNumber;
        this.body = body;
        this.requestNumber = requestNumber;
        this.callbackUrl = callbackUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
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
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
