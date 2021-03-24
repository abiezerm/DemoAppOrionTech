package com.skill.check.orion.tech.DemoAppOrionTech.service;

import com.skill.check.orion.tech.DemoAppOrionTech.model.Employees;

/**
 * Created by jose de leon on 3/23/2021.
 */
public interface EmployeesService {


    Employees saveOrUpdateBusiness(Employees entity);


    Employees[] findAll();

    Employees findById(long id);

    void addEmployee(long businessId, Employees emp);
}
