package com.example.Airport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Airplane {

    @Id
    @GeneratedValue
    private long id;
    private int fuel;
    private String location; //May become an enum in the future. Keeping it simple for now.


    //---------- Getters and setters -----------

    public long getId() {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel (int fuel) {
        this.fuel = fuel;
    }

    public String getLocation () {
        return location;
    }

    public void setLocation (String location) {
        this.location = location;
    }
}
