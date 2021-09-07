package com.flaxinger.springlearnudemyfinal.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

//    @RequestMapping("/admin")
//    String admin(){
//        return "admin";
//    }

    @RequestMapping("/login")
    String login(){
        return "app.login";
    }

    @RequestMapping("/logout")
    String logout(){
        return "app.login";
    }
}
