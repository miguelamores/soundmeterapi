package com.soundmeter.api.service;

import com.soundmeter.api.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by miguelamores on 6/12/17.
 */
public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByMail(String mail);
}
