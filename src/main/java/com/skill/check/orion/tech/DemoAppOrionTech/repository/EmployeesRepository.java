package com.skill.check.orion.tech.DemoAppOrionTech.repository;

import com.skill.check.orion.tech.DemoAppOrionTech.model.Employees;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jose de leon on 3/22/2021.
 */
public interface EmployeesRepository extends CrudRepository<Employees, Long> {
}
