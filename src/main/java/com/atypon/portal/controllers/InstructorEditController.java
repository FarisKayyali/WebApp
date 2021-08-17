package com.atypon.portal.controllers;

import com.atypon.portal.managers.EditMarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class InstructorEditController {
    @Autowired
    EditMarksService ems;

    @RequestMapping(value = "/instructorstudents", method = RequestMethod.POST)
    public String insStPost( @RequestParam String grade[], ModelMap model){
        try{
            ems.editMarks(grade);
            return "login";
        } catch(Exception e){
            e.printStackTrace();
        }
        return "login";
    }
}
