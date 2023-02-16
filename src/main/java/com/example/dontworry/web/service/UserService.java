package com.example.dontworry.web.service;

import com.example.dontworry.domain.user.User;
import com.example.dontworry.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {



    private final UserRepository userRepository;

    public User login(String userId, String password, PasswordEncoder encoder) {
        return userRepository.findByUserId(userId)
                .filter(u -> u != null && encoder.matches(password,u.getPassword()))
                .orElse(null);
    }

    public User create(final User user) {
        if(user == null || user.getUserId() == null ) {
            throw new RuntimeException("Invalid arguments");
        }
        final String userId = user.getUserId();
        if(userRepository.existsByUserId(userId)) {
            log.warn("userId already exists {}", userId);
            throw new RuntimeException("userId already exists");
        }

        return userRepository.save(user);
    }
}
