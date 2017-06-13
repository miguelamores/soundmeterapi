package com.soundmeter.api.rest;

import com.soundmeter.api.model.User;
import com.soundmeter.api.service.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by miguelamores on 6/12/17.
 */
@RestController
@RequestMapping("/users")
public class UserRestController {

    private final UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    private List<User> getUser (){
        return this.userRepository.findAll();
    }
}
