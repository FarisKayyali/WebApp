package com.atypon.portal.controllers;


import com.atypon.portal.managers.AdminManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private AdminManager adminManager;

    @RequestMapping(value = "/admin", method= RequestMethod.POST)
    public String adminPost(@RequestParam String sqlStmt, ModelMap model){
        try{
            int rowsAffected = adminManager.executeAdminQuery(sqlStmt);
            String msg = rowsAffected + " rows Affected";
            model.addAttribute("doneMessage", msg);
        } catch(Exception e) {
            model.addAttribute("errorMessage", "Check your Sql statement!");
            e.printStackTrace();
        }
        return "admin";

    }
}
