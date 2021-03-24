package com.skill.check.orion.tech.DemoAppOrionTech.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by jose de leon on 3/23/2021.
 */
@Component
@Data
public class EmployeeBean {

    private String name;

    private String lastName;

    private String employeeCode;

    private String addressOne;

    private String addressTwo;

    private String addressThree;

}
