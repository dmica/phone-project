package com.ait.clientfeign.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("phone-manager")
public interface PhoneManagerClient
{
    @GetMapping("phones/{phonesId}")
    Phone getPhoneById(@PathVariable int phoneId);
}
