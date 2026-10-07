package com.spring.ray.learning_spring_all.users.service;

import com.spring.ray.learning_spring_all.users.model.User;

import java.util.List;

public interface UserService {

    User createUser(User request);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, User request);

    void deleteUser(Long id);
}
