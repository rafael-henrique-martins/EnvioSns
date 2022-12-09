package com.envio.sns.enviandoSns.controller;

import com.amazonaws.services.sns.model.PublishRequest;
import com.envio.sns.enviandoSns.service.SNSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SNSController {

    @Autowired
    private SNSService service;

    @GetMapping("/sendMessage/{email}")
    public String publishMessageToTopic(@PathVariable String email){
        String response = service.publishMessageToTopic(email);
        return response;
    }
}
