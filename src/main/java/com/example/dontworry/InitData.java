package com.example.dontworry;

import com.example.dontworry.web.service.UserService;
import com.example.dontworry.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitData {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init(){
        User user = User.builder()
                .userId("s12")
                .email("s1@naver.com")
                .password(passwordEncoder.encode("s1234"))
                .build();
        // 서비스를 이용해 리파지토리에 유저 저장
        userService.create(user);

    }
}
