package com.skill.check.orion.tech.DemoAppOrionTech.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by jose de leon on 3/23/2021.
 */
@Component
@Data
public class BusinessBean {

    private long id;

    private String businessName;

    private String ownerName;

    private String ownerSurname;

    private String email;

    private String rnc;


}
