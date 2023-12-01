package com.example.springbootapp.controller;

import com.example.springbootapp.entity.User;
import com.example.springbootapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }

    @GetMapping("/users")
    public String getAllUsers(ModelMap model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/user")
    public String getUserById(@RequestParam(required = false) Long id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "show";
    }

    @GetMapping("/new")
    public String addNewUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        return "new";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@ModelAttribute("userId") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }


    @GetMapping("/update")
    public String getUpdatePage(@ModelAttribute("userId") Long id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }
}
