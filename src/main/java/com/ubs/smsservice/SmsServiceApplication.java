package com.ubs.smsservice;

import com.ubs.smsservice.sms.Sms;
import com.ubs.smsservice.sms.SmsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SmsServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(SmsServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SmsServiceApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(SmsRepository repository) {
        return (args) -> {
            // save a few sms
            repository.save(new Sms("+12012752759", "Please response Yes or No.", "", 1, ""));

            log.info("Sms Repo record count: {}", repository.count());
            for (Sms sms : repository.findAll()) {
                log.info(sms.toString());
            }
        };

    }
}
