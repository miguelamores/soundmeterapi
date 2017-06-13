package com.soundmeter.api.service;

import com.soundmeter.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by miguelamores on 6/12/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByMail(String mail);
}
