package com.tradingApp.trading.controller;

import com.tradingApp.trading.model.user.User;
import com.tradingApp.trading.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUser() {
        return userService.getUserList();
    }

    @GetMapping("/current-user")
    public String getLoggedUser(Principal principal){
        return principal.getName();
    }
}
