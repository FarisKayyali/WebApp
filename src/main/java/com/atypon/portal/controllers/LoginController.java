package com.atypon.portal.controllers;

import com.atypon.portal.managers.AdminManager;
import com.atypon.portal.managers.InstructorManager;
import com.atypon.portal.managers.StudentManager;
import com.atypon.portal.services.LoginService;
import com.atypon.portal.usertypes.Admin;
import com.atypon.portal.usertypes.Instructor;
import com.atypon.portal.usertypes.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private LoginService service;

    @Autowired
    private AdminManager adminManager;

    @Autowired
    private StudentManager studentManager;

    @Autowired
    private InstructorManager instructorManager;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(@RequestParam String name, @RequestParam String password, @RequestParam String usertype, ModelMap model) {
        try {
            switch (usertype) {
                case "Admin":
                    Admin admin = adminManager.validateAdmin(name, password);
                    model.addAttribute("name", admin.getName());
                    return "admin";

                case "Instructor":
                    Instructor instructor = instructorManager.validateInstructor(name, password);
                    model.addAttribute("name", instructor.getName());
                    return "welcome";

                case "Student":
                    Student student = studentManager.validateStudent(name, password);
                    model.addAttribute("name", student.getName());
                    return "welcome";

            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Please check your input fields!!");

        }
        return "login";
    }

}
