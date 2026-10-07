package com.spring.ray.learning_spring_all.users.repository;

import com.spring.ray.learning_spring_all.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
