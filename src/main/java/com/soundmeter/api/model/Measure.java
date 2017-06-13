package com.soundmeter.api.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by miguelamores on 6/12/17.
 */
@Entity
public class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private User user_id;

    private float value;

    private float latitude;

    private float longitude;

    private Date created;

    public Measure() {
    }

    public Measure(User user, float value, float latitude, float longitude, Date created) {
        this.user_id = user;
        this.value = value;
        this.latitude = latitude;
        this.longitude = longitude;
        this.created = created;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user_id;
    }

    public void setUser(User user) {
        this.user_id = user;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
