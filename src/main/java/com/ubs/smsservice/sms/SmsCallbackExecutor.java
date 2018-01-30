package com.ubs.smsservice.sms;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Marcin Grzejszczak
 */
@Service
class SmsCallbackExecutor {

	private final SmsRepository smsRepository;
	private final SomeClient someClient;

	private static final Logger log = LoggerFactory.getLogger(SmsCallbackExecutor.class);

	SmsCallbackExecutor(SmsRepository smsRepository, SomeClient someClient) {
		this.smsRepository = smsRepository;
		this.someClient = someClient;
	}

	public void executeCallbackIfSmsPresent(String phone, String smsContent) {
		SmsEntity sms = smsRepository.findFirstByPhoneNumberOrderByCreatedDateDesc(phone);
		postToCallbackIfPresent(smsContent, sms);
	}

	private void postToCallbackIfPresent(String smsContent, SmsEntity sms) {
		if (sms != null) {
			// save the sms response into the repository
			sms.setResponse(smsContent);
			sms.setModifiedDate(new Timestamp(System.currentTimeMillis()));
			smsRepository.save(sms);
			// call callbackurl to sms object
			ResponseEntity<String> result = this.someClient.postToCallbackUrl(sms.getCallbackUrl(), sms);
		}
	}
}
