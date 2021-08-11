package com.example.demo.controllers;

import com.example.demo.DB;
import com.example.demo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @RequestMapping(value = "/admin", method= RequestMethod.POST)
    public String adminPost(@RequestParam String sqlStmt, ModelMap model){
        System.out.println(sqlStmt);
        if(DB.instance.executeAdminQuery(sqlStmt)){
            model.addAttribute("doneMessage", "Done");
        }
        else{
            model.addAttribute("errorMessage", "Check your SQL Statement");
        }
        return "admin";
    }
}
