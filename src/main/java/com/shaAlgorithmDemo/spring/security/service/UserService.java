package com.shaAlgorithmDemo.spring.security.service;

import com.shaAlgorithmDemo.spring.security.model.User;
import com.shaAlgorithmDemo.spring.security.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User findByUsername(String username);

    User save(UserRegistrationDto registration);

    User save(User user);

    UserDetails currentUserDetails();

    String encodeString(String s);
}
