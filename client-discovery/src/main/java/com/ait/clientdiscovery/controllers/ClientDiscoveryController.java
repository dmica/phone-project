package com.ait.clientdiscovery.controllers;

import com.ait.phonemanager.dto.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ClientDiscoveryController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("client-discovery/phones/{phoneId}")
    public Phone getPhoneFromPhoneMnager(@PathVariable int phoneId)
    {
        RestTemplate restTemplate = new RestTemplate();

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("phone-manager");
        ServiceInstance instance = serviceInstances.get(0);

        String serviceUri = String.format("%s/phones/{phoneId}", instance.getUri().toString());
        System.err.println("ServiceUri : " + serviceUri);

        ResponseEntity<Phone> phoneResponseEntity = restTemplate.exchange(serviceUri,
                HttpMethod.GET, null, Phone.class, phoneId);

        return phoneResponseEntity.getBody();
    }
}


