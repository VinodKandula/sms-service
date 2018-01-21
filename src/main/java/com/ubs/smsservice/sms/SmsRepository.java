package com.ubs.smsservice.sms;

import com.ubs.smsservice.sms.Sms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "smsRequests", path = "smsRequests")
public interface SmsRepository extends JpaRepository<Sms, Long>{

}
