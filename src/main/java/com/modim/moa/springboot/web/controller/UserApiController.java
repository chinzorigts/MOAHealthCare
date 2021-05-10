package com.modim.moa.springboot.web.controller;

import com.modim.moa.springboot.domain.user.User;
import com.modim.moa.springboot.domain.user.UserRepository;
import com.modim.moa.springboot.exception.UserAlreadyExistException;
import com.modim.moa.springboot.exception.UserNotFoundException;
import com.modim.moa.springboot.service.UserService;
import com.modim.moa.springboot.utils.StaticStrings;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("api/moa/getAllUser")
    public List<User> getAllUsers(){
        List<User> listUser = new ArrayList<User>();
        listUser = userRepository.findAll();
        return  listUser;
    }

    @GetMapping("api/moa/checkIfUserExists/{email}")
    public boolean checkIfUserExists(@PathVariable String email){
        return userService.checkIfUserExists(email);
    }

}
