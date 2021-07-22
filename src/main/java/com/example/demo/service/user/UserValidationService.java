package com.example.demo.service.user;

import com.example.demo.domain.model.User;

import java.util.Collection;

public interface UserValidationService {
    Collection<String> validateUser(User user);

}
