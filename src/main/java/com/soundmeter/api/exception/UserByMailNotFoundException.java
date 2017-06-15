package com.soundmeter.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by user on 15/06/2017.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserByMailNotFoundException extends RuntimeException {

    public UserByMailNotFoundException(String mail) {
        super("Could not find user '" + mail +"'.");
    }
}
