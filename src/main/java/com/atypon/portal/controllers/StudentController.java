package com.atypon.portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String studentPost(@RequestParam String name, @RequestParam String password, @RequestParam String usertype, ModelMap model){
        return "student";
    }
}
