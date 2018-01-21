package com.ubs.smsservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "texts", path = "texts")
public interface SmsRepository extends JpaRepository<Sms, Long>{

}
