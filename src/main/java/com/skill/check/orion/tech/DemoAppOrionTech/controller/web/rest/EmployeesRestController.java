package com.skill.check.orion.tech.DemoAppOrionTech.controller.web.rest;

import com.skill.check.orion.tech.DemoAppOrionTech.model.Employees;
import com.skill.check.orion.tech.DemoAppOrionTech.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jose de leon on 3/23/2021.
 */
@RestController
public class EmployeesRestController {

    @Autowired
    private EmployeesService employeesService;

    @PostMapping("/api/Employees")
    public ResponseEntity postEmployees(@RequestBody Employees entity) {
        Employees entityOut = employeesService.saveOrUpdateBusiness(entity);
        return ResponseEntity.ok(entityOut);
    }

    @GetMapping("/api/Employees")
    public ResponseEntity<Employees[]> getEmployeesList() {
        Employees[] list = employeesService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/api/Employees/{id}")
    public ResponseEntity<Employees> getEmployeesById(@PathVariable("id") long id) {
        return ResponseEntity.ok(employeesService.findById(id));
    }
}
