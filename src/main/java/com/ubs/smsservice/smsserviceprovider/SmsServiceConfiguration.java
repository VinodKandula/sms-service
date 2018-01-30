package com.ubs.smsservice.smsserviceprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Marcin Grzejszczak
 */
@Configuration
class SmsServiceConfiguration {

	@Bean
	SmsServiceProvider twilioSmsServiceProvider(
			@Value("${twilio.ACCOUNT_SID}") String accountSid,
			@Value("${twilio.AUTH_TOKEN}") String authToken,
			@Value("${twilio.PHONE_NUMBER}") String phoneNumber) {
		return new TwilioSmsServiceProvider(accountSid, authToken, phoneNumber);
	}

}
