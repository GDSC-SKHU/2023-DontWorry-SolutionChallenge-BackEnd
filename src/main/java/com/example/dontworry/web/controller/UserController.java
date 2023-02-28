package com.example.dontworry.web.controller;

import com.example.dontworry.web.service.UserService;
import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping
public class UserController {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<?> save(@RequestBody UserDto userDTO, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity
                    .badRequest()
                    .body(bindingResult);
        }
        User user = User.builder()
                .userId(userDTO.getUserId())
                .email(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .build();
        // 서비스를 이용해 리파지토리에 유저 저장
        User registeredUser = userService.create(user);
        UserDto responseUserDTO = UserDto.builder()
                .userId(registeredUser.getUserId())
                .email(registeredUser.getEmail())
                .build();

        return ResponseEntity.ok(responseUserDTO);
    }


}
