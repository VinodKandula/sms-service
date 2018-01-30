package com.ubs.smsservice.sms;

import java.util.List;
import java.util.stream.Collectors;

public class SmsService {

    private final SmsRepository smsRepo;

    SmsService(final SmsRepository smsRepo) {
        this.smsRepo = smsRepo;
    }

    private Sms smsFromEntity(SmsEntity smsEntity) {
        return new Sms(smsEntity.getPhoneNumber(), smsEntity.getBody(),
                smsEntity.getRequestNumber(), smsEntity.getCallbackUrl());
    }

    // TODO: most likely adding sms is required

    public List<Sms> findAll() {
        return smsRepo.findAll().stream().map(this::smsFromEntity)
                .collect(Collectors.toList());
    }

}


