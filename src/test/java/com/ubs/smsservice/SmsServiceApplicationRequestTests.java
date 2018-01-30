package com.ubs.smsservice;

import com.ubs.smsservice.sms.Sms;
import com.ubs.smsservice.sms.SmsRepository;
import com.ubs.smsservice.sms.SmsService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SmsServiceApplication.class)
@ActiveProfiles("test")
public class SmsServiceApplicationRequestTests {

    @Test
    public void contextLoads() {
    }

    @Value("${sms.phoneNumber}")
    private String smsPhoneNumber;

    @Value("${sms.callbackUrl}")
    private String smsCallbackUrl;

    private Sms smsRequestOne;

    @Autowired
    private JdbcTemplate template;

    @Test
    public void testDefaultSettings() throws Exception {
        assertThat(this.template.queryForObject("SELECT COUNT(*) FROM SMS",
                Integer.class), is(0));
    }

    private SmsService smsService;

    @Mock
    private SmsRepository smsRepo;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        smsService = new SmsService(smsRepo);
        smsRequestOne = new Sms(smsPhoneNumber, "Test message. Reply Yes or No.", 1, smsCallbackUrl);
    }

    @Test
    public void shouldAddRequestToRepo() throws Exception {
        given(smsRepo.findFirstByPhoneNumberOrderByCreatedDateDesc(smsPhoneNumber)).willReturn(smsRequestOne);

        smsRepo.save(smsRequestOne);
        Sms sms = smsService.findFirstByPhoneNumberOrderByCreatedDateDesc(smsPhoneNumber);

        assertThat(sms, is(smsRequestOne));
    }

//    @Test
//    public void shouldReturnEmptyList() throws Exception {
//        List<Sms> emptySmsList = new ArrayList<Sms>();
//        given(smsRepo.findByPhoneNumber(anyString())).willReturn(emptySmsList);
//
//        List<Sms> smsList = smsService.findByPhoneNumber(smsPhoneNumber);
//
//        assertThat(smsList, Matchers.hasSize(0));
//    }

}
