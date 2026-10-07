package com.spring.ray.learning_spring_all.helloworldproject.controller;

import lombok.Data;

@Data
public class HelloWorldBean {
    private String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }
}
