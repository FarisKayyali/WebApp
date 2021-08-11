package com.example.demo.services;

import com.example.demo.DB;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public char validateUser(String id, String password) {
        char typeOfUser = 'N';
        typeOfUser = DB.instance.userType(id, password);
        return typeOfUser;// user.equalsIgnoreCase("John") && password.equals("dummy");
    }
}
