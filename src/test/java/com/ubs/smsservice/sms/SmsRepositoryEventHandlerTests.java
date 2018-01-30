package com.ubs.smsservice.sms;

import com.ubs.smsservice.smsserviceprovider.SmsServiceProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Marcin Grzejszczak
 */
@RunWith(SpringRunner.class)
@SpringBootTest
// TODO: Set it to fix  org.hibernate.tool.schema.spi.SchemaManagementException: Schema-validation: missing table [sms_entity]
public class SmsRepositoryEventHandlerTests {

	@MockBean SmsServiceProvider provider;
	@Autowired SmsRepository repository;

	@Test public void should_emit_an_event_after_storing_data_to_db() {
		//given:
		// an entity

		//when:
		// repository.save(...)

		//then:
		// verify that provider got provider.sendSms got executed
	}

	@EnableAutoConfiguration
	static class Config {

	}
}