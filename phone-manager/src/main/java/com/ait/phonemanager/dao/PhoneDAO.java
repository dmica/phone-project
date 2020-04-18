package com.ait.phonemanager.dao;

import com.ait.phonemanager.dto.Phone;
import com.ait.phonemanager.exceptions.PhoneNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PhoneDAO {
    private List<Phone> phoneList = new LinkedList<>(Arrays.asList(
            new Phone(0, "Redmi 7a", "Xiaomi", 2019, "Android", 199.99, "redmi_7a.jpg"),
            new Phone(1, "P Smart Z", "Huawei", 2020, "Android", 249.99, "p-smart-z.png"),
            new Phone(2, "Galaxy A50", "Samsung", 2019, "Android", 59.99, "galaxy_a50.jpg"),
            new Phone(3, "Galaxy A40", "Samsung", 2018, "Android", 124.99, "galaxy_a40.jpg"),
            new Phone(4, "Mi Mix 2s", "Xiaomi", 2020, "Android", 89.99, "mi_mix_2s.jpg"),
            new Phone(5, "Galaxy A10", "Samsung", 2017, "Android", 59.99, "galaxy_a10.jpg"),
            new Phone(6, "P Smart 2019", "Huawei", 2017, "Android", 399.99, "p_smart_2019.jpg"),
            new Phone(7, "Galaxy A20e", "Samsung", 2020, "Android", 129.99, "galaxy_a20.jpg"),
            new Phone(8, "P30 Pro", "Huawei", 2018, "Android", 299.99, "p30_pro.jpg"),
            new Phone(9, "Galaxy A70", "Samsung", 2020, "Android", 159.99, "domaine_serene.jpg"),
            new Phone(10, "P30", "Huawei", 2018, "Android", 199.99, "p30.jpg")
    ));

    private Phone findPhone(int phoneId) {
        Phone found = null;
        for (Phone phone : phoneList) {
            if (phone.getId() == phoneId) {
                found = phone;
                break;
            }
        }
        return found;
    }

    public List<Phone> findAll() {
        return phoneList;
    }

//    public Optional<Phone> findById(int id)
//    {
//        return Optional.ofNullable(findPhone(id));
//    }

    public Optional<Phone> findById(int id)
    {
        Phone foundPhone = findPhone(id);
        if(foundPhone != null)
            return Optional.ofNullable(foundPhone);
        else
            throw new PhoneNotFoundException("Unable to find phone with id : " + id);
    }

    public void deletePhone(int id)
    {
        Phone foundPhone = findPhone(id);
        if(foundPhone != null)
            phoneList.remove(foundPhone);
        else
            throw new PhoneNotFoundException("Unable to find phone with id: " +id);
    }

    public void createPhone(Phone newPhone)
    {
        phoneList.add(newPhone);
    }

    public boolean updatePhone(Phone phone)
    {
        boolean updated = true;
        Phone foundPhone = findPhone(phone.getId());
        if(foundPhone != null)
        {
            int index = phoneList.indexOf(foundPhone);
            phoneList.remove(index);
            phoneList.add(index, phone);
        }
        else
        {
            phoneList.add(phone);
            updated = false;
        }
        return updated;
    }
}
