package com.springbootjpamanytomany.service;

import com.springbootjpamanytomany.model.User;

import java.util.List;

public interface UserService {

    User findUserById(Long id);
    List<User> findAllUsers();
    User createUser(User user);
    User updateUser(User user);
    void deleteUserById(Long id);

}
