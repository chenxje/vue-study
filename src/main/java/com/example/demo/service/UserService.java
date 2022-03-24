package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    String CreateUser(User user);

    String updateEnabledUser(List<Integer> ids, boolean enabled);

    String deleteUser(List<Integer> ids);
}
