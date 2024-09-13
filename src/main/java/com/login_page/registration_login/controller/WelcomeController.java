package com.login_page.registration_login.controller;

import com.login_page.registration_login.model.User;
import com.login_page.registration_login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
    @Autowired
    private UserService userService;



    @GetMapping("/welcome")
    public ModelAndView welcome(@AuthenticationPrincipal UserDetails userDetails) {
        ModelAndView modelAndView = new ModelAndView("welcome");
        User loggedInUser = userService.findUserByEmail(userDetails.getUsername());
        if (userDetails != null) {
            modelAndView.addObject("name", loggedInUser.getName());
        }
        return modelAndView;
    }
}
