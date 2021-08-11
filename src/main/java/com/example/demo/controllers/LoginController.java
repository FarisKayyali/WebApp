package com.example.demo.controllers;

import com.example.demo.managers.AdminManager;
import com.example.demo.managers.InstructorManager;
import com.example.demo.managers.StudentManager;
import com.example.demo.services.LoginService;
import com.example.demo.usertypes.Admin;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    LoginService service;

    @Autowired
    AdminManager adminManager;

    @Autowired
    StudentManager studentManager;

    @Autowired
    InstructorManager instructorManager;

    Admin admin;

    @RequestMapping(value = "/login", method= RequestMethod.GET)
    public String loginGet(){
        return "login";
    }

    @RequestMapping(value = "/login", method= RequestMethod.POST)
    public String loginPost(@RequestParam String name, @RequestParam String password, @RequestParam String usertype, ModelMap model){

        if (usertype.equals("Admin")) {
            if((admin = adminManager.validateAdmin(name, password)) != null){
            model.addAttribute("name", name);
            return "admin";
            }
        } else if (usertype.equals("Instructor")) {
            instructorManager.validateInstructor(name, password);
            model.addAttribute("name", name);
            return "welcome";
        } else if (usertype.equals("Student")){
            studentManager.validateStudent(name, password);
            model.addAttribute("name", name);
            return "admin";
        }

        model.addAttribute("errorMessage", "Please check your input fields!!");
        return "login";

    }

}
