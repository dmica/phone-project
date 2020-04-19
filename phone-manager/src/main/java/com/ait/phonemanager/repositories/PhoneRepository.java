package com.ait.phonemanager.repositories;


import com.ait.phonemanager.dto.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Integer>
{

}


