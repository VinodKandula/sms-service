package com.ubs.smsservice.sms;

import com.ubs.smsservice.sms.Sms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "smsRequests", path = "smsRequests")
public interface SmsRepository extends JpaRepository<Sms, Long>{

    List<Sms> findByPhoneNumber(String phoneNumber);

    //@Query(value="SELECT * FROM SMS WHERE phonenumber = ?1", nativeQuery = true)
    //List<Sms> findByPhoneNumber(String phoneNumber);

}
