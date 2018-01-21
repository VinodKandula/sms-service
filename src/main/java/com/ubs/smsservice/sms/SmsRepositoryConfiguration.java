package com.ubs.smsservice.sms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmsRepositoryConfiguration {

    @Bean
    SmsRepositoryEventHandler smsEventHandler() {

        return new SmsRepositoryEventHandler();
    }
}
