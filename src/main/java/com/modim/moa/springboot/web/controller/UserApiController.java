package com.modim.moa.springboot.web.controller;

import com.modim.moa.springboot.domain.user.User;
import com.modim.moa.springboot.domain.user.UserRepository;
import com.modim.moa.springboot.exception.UserNotFoundException;
import com.modim.moa.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/api/moa/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/api/moa/findUserByEmail/{email}")
    public User findUserByEmail(@PathVariable String email)
    {
       return userService.findUserByEmail(email);
    }


}
