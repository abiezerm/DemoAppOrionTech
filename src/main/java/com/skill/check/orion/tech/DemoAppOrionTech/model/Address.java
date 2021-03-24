package com.skill.check.orion.tech.DemoAppOrionTech.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jose de leon on 3/22/2021.
 */
@Data
@Entity
public class Address {

    @Id
    @GeneratedValue
    private long id;

    private String street;

    public Address(String address){
        this.street = address;
    }

    public Address(){}

}
