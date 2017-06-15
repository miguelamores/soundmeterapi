package com.soundmeter.api.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by miguelamores on 6/12/17.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long user_id;

    private String name;

    private String mail;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Measure> measures = new ArrayList<>();

    public User() {
    }

    public User(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
