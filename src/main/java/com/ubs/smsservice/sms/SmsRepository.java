package com.ubs.smsservice.sms;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "smsRequests", path = "smsRequests")
@Api(value="smsRequests", description="Operations pertaining to SMS Requests")
interface SmsRepository extends JpaRepository<SmsEntity, Long>{

    @ApiOperation("find all SMS Requests that are associated with a given phone number")
    List<SmsEntity> findByPhoneNumber(String phoneNumber);

    @ApiOperation("find the latest SMS Request associated with a given phone number by created date")
    SmsEntity findFirstByPhoneNumberOrderByCreatedDateDesc(String phoneNumber);


}
