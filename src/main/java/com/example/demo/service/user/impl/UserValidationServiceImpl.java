package com.example.demo.service.user.impl;

import com.example.demo.domain.model.User;
import com.example.demo.service.user.UserValidationService;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
@Service
public class UserValidationServiceImpl implements UserValidationService {
    private int minUsernameLength;
    private int minPasswordLength;

    @Override
    public Collection<String> validateUser(@NotNull User user) {
        List<String> errors = new ArrayList<>();
        if(user.getUsername() == null || user.getUsername().isEmpty() || user.getUsername().length() < minUsernameLength){
            errors.add("Username is incorrect");
        }
        if(user.getPassword() == null || user.getPassword().isEmpty() || user.getPassword().length() < minPasswordLength){
            errors.add("Password is incorrect");
        }
        return errors;
    }
}
