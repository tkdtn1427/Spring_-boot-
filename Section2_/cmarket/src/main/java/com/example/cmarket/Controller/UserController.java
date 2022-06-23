package com.example.cmarket.Controller;

import com.example.cmarket.user.User;
import com.example.cmarket.user.UserGrade;
import com.example.cmarket.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public String signupUser(){
        User user = new User(0L,"kimcoding",UserGrade.GRADE_2);

        userService.signup(user);
        return "가입완료";


    }
}

//실습내용
