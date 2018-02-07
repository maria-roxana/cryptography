package com.shaAlgorithmDemo.spring.security.service;

import com.shaAlgorithmDemo.spring.security.model.User;
import com.shaAlgorithmDemo.spring.security.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
