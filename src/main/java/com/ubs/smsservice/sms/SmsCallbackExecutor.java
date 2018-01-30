package com.ubs.smsservice.sms;

import java.sql.Timestamp;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Marcin Grzejszczak
 */
@Service
class SmsCallbackExecutor {

	private final SmsRepository smsRepository;
	private final SomeClient someClient;

	SmsCallbackExecutor(SmsRepository smsRepository, SomeClient someClient) {
		this.smsRepository = smsRepository;
		this.someClient = someClient;
	}

	public void executeCallbackIfSmsPresent(String phone, String smsContent) {
		System.out.println("phone: " + phone);
		System.out.println("smsContent: " + smsContent);
		SmsEntity sms = smsRepository.findFirstByPhoneNumberOrderByCreatedDateDesc(phone);
		postToCallbackIfPresent(smsContent, sms);
	}

	private void postToCallbackIfPresent(String smsContent, SmsEntity sms) {
		if (sms != null) {
			System.out.println("found item: " + sms.toString());
			// save the sms response into the repository
			sms.setResponse(smsContent);
			sms.setModifiedDate(new Timestamp(System.currentTimeMillis()));
			smsRepository.save(sms);
			System.out.println("Saved: " + sms.toString());
			// call callbackurl to sms object
			ResponseEntity<String> result = this.someClient.postToCallbackUrl(sms.getCallbackUrl(), sms);
			System.out.println(result);
		}
	}
}
