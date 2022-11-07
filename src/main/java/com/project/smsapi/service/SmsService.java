package com.project.smsapi.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.project.smsapi.entity.Sms;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

//@Service
@Component
public class SmsService {

	private final String ACCOUNT_SID ="ACe4af9e521a47933c12cf4d98f8dcc074";

    private final String AUTH_TOKEN = "fe9d9dede28f6d41f027e8375b44b231";

    private final String FROM_NUMBER = "+17128008024";

    public void send(Sms sms) {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }


}
