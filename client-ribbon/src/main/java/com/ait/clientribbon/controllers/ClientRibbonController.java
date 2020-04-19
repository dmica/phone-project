package com.ait.clientribbon.controllers;


import com.ait.phonemanager.dto.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientRibbonController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("client-ribbon/phones/{phoneId}")
    public Phone getPhoneFromPhoneManager(@PathVariable int phoneId)
    {
        ResponseEntity<Phone> phoneResponseEntity = restTemplate.exchange(
            "htt://phone-manager/phones/{phoneId}",
            HttpMethod.GET, null, Phone.class, phoneId);

        return phoneResponseEntity.getBody();
    }
}
