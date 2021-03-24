package com.skill.check.orion.tech.DemoAppOrionTech.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose de leon on 3/22/2021.
 */
@Data
@Entity
public class Employees {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String lastName;

    private String employeeCode;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Address> address =  new ArrayList<>();

}
