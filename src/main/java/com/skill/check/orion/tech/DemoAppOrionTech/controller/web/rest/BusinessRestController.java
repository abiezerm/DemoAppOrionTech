package com.skill.check.orion.tech.DemoAppOrionTech.controller.web.rest;

import com.skill.check.orion.tech.DemoAppOrionTech.model.Business;
import com.skill.check.orion.tech.DemoAppOrionTech.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jose de leon on 3/23/2021.
 */
@RestController
public class BusinessRestController {

    @Autowired
    private BusinessService businessService;

    @PostMapping("/api/business")
    public ResponseEntity postBusiness(@RequestBody Business entity) {
        Business entityOut = businessService.saveOrUpdateBusiness(entity);
        return ResponseEntity.ok(entityOut);
    }

    @GetMapping("/api/business")
    public ResponseEntity<Business[]> getBusinessList() {
        Business[] list = businessService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/api/business/{id}")
    public ResponseEntity<Business> getBusinessById(@PathVariable("id") long id) {
        return ResponseEntity.ok(businessService.findById(id));
    }
}
