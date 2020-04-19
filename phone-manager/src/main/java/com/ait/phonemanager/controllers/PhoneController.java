package com.ait.phonemanager.controllers;
import com.ait.phonemanager.dto.Phone;
import com.ait.phonemanager.repositories.PhoneRepository;
import com.ait.phonemanager.exceptions.PhoneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class PhoneController {

    @Autowired
    PhoneRepository phoneRepository;

    @GetMapping("phones")
    public List<Phone> getAllPhones()
    {
        return phoneRepository.findAll();
    }

    @GetMapping("phones/{phoneId}")
    public Phone getWPhoneById(@PathVariable int phoneId)
    {
        Optional<Phone> foundPhone = phoneRepository.findById(phoneId);
        if(foundPhone.isPresent())
            return foundPhone.get();
        else
            throw new PhoneNotFoundException("Unable to retrieve phone with id:" + phoneId);
    }

    @DeleteMapping("phones/{phoneId}")
    public void deletePhoneById(@PathVariable int phoneId)
    {
        try
        {
            phoneRepository.deleteById(phoneId);
        }
        catch (EmptyResultDataAccessException e) {
            throw new PhoneNotFoundException("Unable to delete phone with id:" + phoneId);
        }
    }

    @PostMapping("phones/")
    public ResponseEntity createPhone(@RequestBody Phone newPhone)
    {
        Phone savedPhone = phoneRepository.save(newPhone);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(newPhone.getId()).toUri();
         return ResponseEntity.created(location).build();
    }

    @PutMapping("phones/")
    public ResponseEntity updatedPhone(@RequestBody Phone newPhone) {
        if (newPhone.getId() !=null)
        {
            phoneRepository.save(newPhone);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else
         {
             Phone savedPhone = phoneRepository.save(newPhone);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("{id}")
                    .buildAndExpand(newPhone.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
    }
}
