package com.ubs.smsservice;

import com.ubs.smsservice.sms.Sms;
import com.ubs.smsservice.sms.SmsRepository;
import com.ubs.smsservice.sms.SmsService;
import com.ubs.smsservice.smsresponse.SmsResponseController;
import com.ubs.smsservice.smsserviceprovider.SmsServiceProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SmsServiceApplication.class)
@ActiveProfiles("test")
public class SmsServiceApplicationResponseTests {

	Logger logger = LoggerFactory.getLogger(SmsServiceApplicationResponseTests.class);

	@Test
	public void contextLoads() {
	}

	@Value("${sms.phoneNumber}")
	private String smsPhoneNumber;

	@Value("${sms.callbackUrl}")
	private String smsCallbackUrl;

	private Sms smsRequestOne;

	private SmsResponseController smsResponseController;

	private SmsService smsService;

	@Mock
	private SmsRepository smsRepo;

	@Mock
	private SmsServiceProvider smsServiceProvider;

	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	@Before
	public void setUp() throws Exception {
		initMocks(this);
		smsService = new SmsService(smsRepo);
		smsResponseController = new SmsResponseController(smsService, smsServiceProvider);
		smsRequestOne = new Sms(smsPhoneNumber, "Test message. Reply Yes or No.", 1, smsCallbackUrl);
	}

	@Test
	public void shouldUpdateSmsRecordInRepo() throws Exception {

		given(smsRepo.findFirstByPhoneNumberOrderByCreatedDateDesc(smsPhoneNumber)).willReturn(smsRequestOne);

		given(request.getParameter("From")).willReturn(smsPhoneNumber);
		given(request.getParameter("Body")).willReturn("Yes");
		when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));
		//given(smsResponseController.postToCallbackUrl(smsCallbackUrl, smsRequestOne)).willReturn(smsRequestOne);

		smsRepo.save(smsRequestOne);
		smsResponseController.smsResponse(request, response);
		Sms sms = smsService.findFirstByPhoneNumberOrderByCreatedDateDesc(smsPhoneNumber);

		assertThat(sms, is(smsRequestOne));
		assertThat(smsRequestOne.getResponse(), is("Yes"));

	}

}
