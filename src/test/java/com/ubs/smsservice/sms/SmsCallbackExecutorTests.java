package com.ubs.smsservice.sms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;

/**
 * @author Marcin Grzejszczak
 */
@RunWith(MockitoJUnitRunner.class)
public class SmsCallbackExecutorTests {

	@Mock SmsRepository smsRepository;
	@Mock SomeClient someClient;
	@InjectMocks SmsCallbackExecutor executor;

	@Test
	public void should_store_an_entry_in_db_and_send_callback_when_sms_exists() {
		//given:
		SmsEntity entity = new SmsEntity();
		given(smsRepository.findFirstByPhoneNumberOrderByCreatedDateDesc(anyString()))
				.willReturn(entity);

		//when:
		executor.executeCallbackIfSmsPresent("foo", "bar");

		//then:
		then(smsRepository).should().save(entity);
		then(someClient).should().postToCallbackUrl(anyString(), any(Object.class));
	}

	@Test
	public void should_not_execute_any_callback_when_there_is_no_sms() {
		//when:
		executor.executeCallbackIfSmsPresent("foo", "bar");

		//then:
		then(smsRepository).should(never()).save(any(SmsEntity.class));
		then(someClient).should(never()).postToCallbackUrl(anyString(), any(Object.class));
	}
}