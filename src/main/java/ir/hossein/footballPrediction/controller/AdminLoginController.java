package ir.hossein.footballPrediction.controller;


import ir.hossein.footballPrediction.form.AdminLoginForm;
import ir.hossein.footballPrediction.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("adminLoginForm.html")
public class AdminLoginController {

    @Autowired
    public AdminLoginService adminLoginService;

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(Map model) {
        AdminLoginForm adminLoginForm = new AdminLoginForm();
        model.put("adminLoginForm", adminLoginForm);

        return "adminLoginForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(@Valid AdminLoginForm adminLoginForm, BindingResult result, Map model) {

        if (result.hasErrors()) {
            return "adminLoginForm";
        }
        boolean adminExists = adminLoginService.checkLogin(adminLoginForm.getUserName(),adminLoginForm.getPassword());
        if(adminExists){
            model.put("adminLoginForm", adminLoginForm);
            return "adminLoginSuccess";
        }else{
            result.rejectValue("userName","invaliduser");
            return "adminLoginForm";
        }

    }
}
