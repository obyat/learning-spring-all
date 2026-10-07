package com.spring.ray.learning_spring_all.users.service;

import com.spring.ray.learning_spring_all.users.exception.UserNotFoundException;
import com.spring.ray.learning_spring_all.users.model.User;
import com.spring.ray.learning_spring_all.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User request) {

        User user = new User();

        user.setName(request.getName());
        user.setBirthDate(request.getBirthDate());
        User savedUser = userRepository.save(user);

        if (user.getName() == null || user.getName().isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        return new User(
                savedUser.getName(),
                savedUser.getId(),
                savedUser.getBirthDate()
        );
    }


    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id) //
                .orElseThrow(() -> new UserNotFoundException("User not found with id:" + id));
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public User updateUser(Long id, User request) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with id: " + id
                        )
                );

        existingUser.setName(request.getName());
        existingUser.setBirthDate(request.getBirthDate());

        return userRepository.save(existingUser);
    }


    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id:" + id));
        userRepository.delete(user);
    }
}