package com.ubs.smsservice;

import java.util.List;

import com.ubs.smsservice.sms.Sms;
import com.ubs.smsservice.sms.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;

@SpringBootApplication
@Import(SpringDataRestConfiguration.class)
public class SmsServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(SmsServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SmsServiceApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(SmsService smsService) {
        return (args) -> {
            // publish sms messages in DB
			List<Sms> all = smsService.findAll();
			log.info("Sms Repo record count: {}", all.size());
            for (Sms sms : all) {
                log.info(sms.toString());
            }
        };

    }


/*
    @Bean
     public class MyBean implements CommandLineRunner {

        public void run(String... args) {
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject("http://www.example.com/api/resource", String.class);
        }

    }
*/

}
