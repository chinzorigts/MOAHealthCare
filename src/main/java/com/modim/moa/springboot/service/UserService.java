package com.modim.moa.springboot.service;

import com.modim.moa.springboot.domain.user.User;
import com.modim.moa.springboot.domain.user.UserRepository;
import com.modim.moa.springboot.exception.UserNotFoundException;
import com.modim.moa.springboot.utils.StaticStrings;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User findUserByEmail(String email){

        User user = userRepository.findById(email).orElse(null);
        if(user == null)
        {
            throw new UserNotFoundException(StaticStrings.USER_NOT_FOUND +" : " + email);
        }
        return user;
    }
}
