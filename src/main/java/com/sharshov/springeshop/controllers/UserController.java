package com.sharshov.springeshop.controllers;

import com.sharshov.springeshop.dto.UserDTO;
import com.sharshov.springeshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new UserDTO());
        return "user";
    }

    @PostMapping("/new")
    public String saveUser(UserDTO dto, Model model){
        if (userService.save(dto)){
            return "redirect:/";
        }else {
            model.addAttribute("user",dto);
            return "user";
        }
    }
}
