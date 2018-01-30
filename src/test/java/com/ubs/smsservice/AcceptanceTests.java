package com.ubs.smsservice;

import org.junit.Test;

/**
 * @author Marcin Grzejszczak
 */
public class AcceptanceTests {

	@Test
	public void should_execute_a_callback_when_sms_present() {
		// given:
		//   a sms is in the db (flyway / rest call)

		// when:
		//   a request is sent

		// then:
		//   a POST callback has been executed (WireMock verification)
		//   the sms entry got modified
	}

	@Test
	public void should_not_execute_a_callback_when_no_sms_present() {
		// given:
		//   a sms is not in the db

		// when:
		//   a request is sent

		// then:
		//   a POST callback has NOT been executed (WireMock verification)
		//   the sms entry did not get modified
	}
}
