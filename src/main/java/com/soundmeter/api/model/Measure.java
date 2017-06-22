package com.soundmeter.api.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by miguelamores on 6/12/17.
 */
@Entity
public class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    private float val;

    private float latitude;

    private float longitude;

    private Date created;

    public Measure() {
    }

    public Measure(AppUser appUser, float val, float latitude, float longitude, Date created) {
        this.user = appUser;
        this.val = val;
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

    public AppUser getAppUser() {
        return user;
    }

    public void setAppUser(AppUser appUser) {
        this.user = appUser;
    }

    public float getVal() {
        return val;
    }

    public void setVal(float val) {
        this.val = val;
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
