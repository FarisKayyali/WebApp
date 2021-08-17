package com.atypon.portal.controllers;

import com.atypon.portal.managers.EditMarksService;
import com.atypon.portal.managers.InstructorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class InstructorController {

    @Autowired
    private InstructorManager instructorManager;

    @RequestMapping(value = "/instructorcourses", method = RequestMethod.POST)
    public String insPost(@RequestParam String course, ModelMap model){
        try{
            List<String> instructorStudents = instructorManager.getInstructorStudents(course);
            model.addAttribute("inSt", instructorStudents);
            model.addAttribute("course", course);
            EditMarksService.oldData = instructorStudents;
            EditMarksService.courseName = course;
            return "instructorstudents";
        } catch(Exception e){
            e.printStackTrace();
            model.addAttribute("errorMessage", "Check course name!");
        }
        return "instructorcourses";
    }



}
