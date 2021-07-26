package com.example.demo.service.user;

import com.example.demo.domain.model.User;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collection;
@ComponentScan()
public interface UserValidationService {
    Collection<String> validateUser(User user);

}
