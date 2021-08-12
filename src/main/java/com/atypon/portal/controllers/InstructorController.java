package com.atypon.portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InstructorController {

    @RequestMapping(value = "/instructor", method = RequestMethod.POST)
    public String insPost(@RequestParam String name, @RequestParam String password, @RequestParam String usertype, ModelMap model){
        return "instructor";
    }
}
