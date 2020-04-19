package com.ait.clientfeign.controllers;

import com.ait.clientfeign.feignclients.PhoneManagerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientFeifnController {
    @Autowired
    PhoneManagerClient phoneManagerClient;

    @GetMapping("client-feign/phones/{phoneId}")
    public Phone getPhoneFromPhoneManager(@PathVariable int phoneId)
    {
        return phoneManagerClient.getPhoneById(phoneId);
    }
}
