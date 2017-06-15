package com.soundmeter.api.rest;

import com.soundmeter.api.exception.UserByMailNotFoundException;
import com.soundmeter.api.model.AppUser;
import com.soundmeter.api.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * Created by miguelamores on 6/12/17.
 */
@RestController
@RequestMapping("/users")
public class UserRestController {

    final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    private final UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    private List<AppUser> getUser (){
        logger.info("Listing all USERS");
        return this.userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity<?> addUser(@RequestBody AppUser user) {
        AppUser u1 = userRepository.save(user);
        logger.info("User created", u1);
        return new ResponseEntity<Object>(u1, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{mail}")
    private Optional<AppUser> getUserByMail(@PathVariable  String mail) {
        return this.userRepository.findByMail(mail);
    }
}
