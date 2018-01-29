package com.ubs.smsservice;

import com.ubs.smsservice.sms.Sms;
import com.ubs.smsservice.sms.SmsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsRepositoryTests {

    @Autowired
    SmsRepository repository;

    @Test
    public void createSms() throws Exception {
        Sms sms = new Sms();
        sms.setPhoneNumber("+12015551234");
        sms.setBody("Test message");
        sms.setCallbackUrl("http://serviceworks.ubs.com");
        sms.setRequestNumber(123);

        repository.save(sms);
    }

}