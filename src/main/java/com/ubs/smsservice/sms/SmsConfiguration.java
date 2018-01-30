package com.ubs.smsservice.sms;

import com.ubs.smsservice.smsserviceprovider.SmsServiceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class SmsConfiguration {

    @Bean RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    SmsRepositoryEventHandler smsEventHandler(SmsServiceProvider smsService) {
        return new SmsRepositoryEventHandler(smsService);
    }

    @Bean
    SmsCallbackExecutor smsCallbackExecutor(SmsRepository smsRepository,
            SomeClient someClient) {
        return new SmsCallbackExecutor(smsRepository, someClient);
    }

    @Bean
    SmsService smsService(SmsRepository smsRepository) {
        return new SmsService(smsRepository);
    }

    @Bean
    SomeClient someClient() {
        return new SomeClient(restTemplate());
    }
}
