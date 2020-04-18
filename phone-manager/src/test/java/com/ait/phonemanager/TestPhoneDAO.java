package com.ait.phonemanager;

import com.ait.phonemanager.dao.PhoneDAO;

public class TestPhoneDAO {

    public static void main(String[] args)
    {
        PhoneDAO phoneDAO = new PhoneDAO();
        System.out.println("All Phones: " + phoneDAO.findAll());
        System.out.println("Phone with id 2:" + phoneDAO.findById(2));
    }
}
