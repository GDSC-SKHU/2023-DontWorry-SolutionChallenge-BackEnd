package com.example.dontworry.web.controller;

import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.argumentresolver.Login;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/index")
    public String index(@Login User loginMember , Model model){
        if (loginMember == null) {
            return "로그인해줘";
        }

        //세션이 유지되면 로그인으로 이동
        model.addAttribute("member", loginMember);
        return "로그인 완료 : " + loginMember.getUserId();
    }

    @GetMapping("/test")
    public String test(){
        return "test성공";
    }
}
