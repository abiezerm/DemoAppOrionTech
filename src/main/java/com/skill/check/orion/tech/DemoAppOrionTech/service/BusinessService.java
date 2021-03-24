package com.skill.check.orion.tech.DemoAppOrionTech.service;

import com.skill.check.orion.tech.DemoAppOrionTech.model.Business;

/**
 * Created by jose de leon on 3/22/2021.
 */
public interface BusinessService {

    Business saveOrUpdateBusiness(Business business);

    Business[] findAll();

    Business findById(long id);
}
