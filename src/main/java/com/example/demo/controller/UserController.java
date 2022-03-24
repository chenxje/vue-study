package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @GetMapping("/infos")
    public PageInfo<User> findAllUsers(){
        PageHelper.startPage(1, 20);
        List<User> users = userService.findAllUsers();
        PageInfo<User> pageInfo = new PageInfo(users);
        return pageInfo;
    }

    @PostMapping("/info")
    public String createUser(@RequestBody User user){
//        String password = user.getPassword();
//        password = passwordEncoder.encode(password);
//        user.setPassword(password);
        String result = userService.CreateUser(user);
        return result;
    }

    @PostMapping("/update")
    public String updateEnabledUser(@RequestBody Map<String, Object> map){
        String result = userService.updateEnabledUser((ArrayList) map.get("ids"), (Boolean) map.get("enabled"));
        return result;
    }

    @DeleteMapping("/info")
    public String deleteUser(@RequestBody Map<String, Object> map){
        String result = userService.deleteUser((ArrayList) map.get("ids"));
        return result;
    }
}
