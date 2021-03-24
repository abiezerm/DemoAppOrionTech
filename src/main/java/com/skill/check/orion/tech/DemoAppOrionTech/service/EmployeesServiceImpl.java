package com.skill.check.orion.tech.DemoAppOrionTech.service;

import com.skill.check.orion.tech.DemoAppOrionTech.model.Business;
import com.skill.check.orion.tech.DemoAppOrionTech.model.Employees;
import com.skill.check.orion.tech.DemoAppOrionTech.repository.BusinessRepository;
import com.skill.check.orion.tech.DemoAppOrionTech.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

/**
 * Created by jose de leon on 3/23/2021.
 */
@Service
public class EmployeesServiceImpl implements EmployeesService{

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public Employees saveOrUpdateBusiness(Employees entity) {
        return employeesRepository.save(entity);
    }

    @Override
    public Employees[] findAll() {
        Iterable<Employees> list = employeesRepository.findAll();
        Employees[] array = StreamSupport.stream(list.spliterator(), false).toArray(Employees[]::new);
        return array;
    }

    @Override
    public Employees findById(long id) {
        return null;
    }

    @Override
    public void addEmployee(long businessId, Employees emp) {



        Employees entity = employeesRepository.save(emp);

        Business bus = businessRepository.findById(businessId).get();

        bus.getEmployeesList().add(entity);

        businessRepository.save(bus);
    }
}
