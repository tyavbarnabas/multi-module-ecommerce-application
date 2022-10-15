package com.shoponlineapplication.admin.controller;

import com.shoponlineapplication.library.dto.AdminDto;
import com.shoponlineapplication.library.impl.AdminServiceImpl;
import com.shoponlineapplication.library.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class loginController {

    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public  String loginForm(Model model){
        model.addAttribute("title","Login");
        return "login";
    }

    @GetMapping("/index")
    public String IndexPage(Model model){
        model.addAttribute("title","Home page");
        return "index";
    }


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("title","Register");
        model.addAttribute("adminDto",new AdminDto());
        return "register";

    }

    @GetMapping("/forgot-password")
    public String forgotPassword(Model model){
        model.addAttribute("Title","Forgot password");
        return "forgot-password";
    }

    @PostMapping("/register-new")
    public String addNewAdmin(@Valid  @ModelAttribute("adminDto")AdminDto adminDto, BindingResult result, Model model){
        try {

            if(result.hasErrors()){
                model.addAttribute("adminDto",adminDto);
                result.toString();
                return "register";
            }
            String username = adminDto.getUsername();
            Admin admin = adminService.findByUsername(username);
            if(admin != null){
                model.addAttribute("adminDto",adminDto);
                System.out.println("admin not null");
                model.addAttribute("emailError","Your email has been registered");
                return "register";
            }
            if(adminDto.getPassword().equals(adminDto.getRepeatPassword())){
                adminDto.setPassword(passwordEncoder.encode(adminDto.getPassword()));
                adminService.save(adminDto);
                System.out.println("Registration successful");
                model.addAttribute("success","Registered successfully");
                model.addAttribute("adminDto",adminDto);

            }else{
                model.addAttribute("adminDto",adminDto);
                model.addAttribute("passwordError","You entered a wrong password,check your password and try again");
                System.out.println("Unmatched password ");
                return "register";
            }

        }catch (Exception e){
            e.printStackTrace();
          model.addAttribute("errors","some went wrong with the sever!");
        }
        return "register";

    }

}
