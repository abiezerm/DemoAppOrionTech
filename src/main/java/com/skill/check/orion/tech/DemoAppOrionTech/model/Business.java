package com.skill.check.orion.tech.DemoAppOrionTech.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by jose de leon on 3/22/2021.
 */
@Data
@Entity
public class Business {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String ownerName;

    private String ownerSurname;

    private String email;

    private String rnc;

    @OneToMany
    private List<Employees> employeesList;

}
