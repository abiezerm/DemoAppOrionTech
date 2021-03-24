package com.skill.check.orion.tech.DemoAppOrionTech.controller.web;

import com.skill.check.orion.tech.DemoAppOrionTech.model.Business;
import com.skill.check.orion.tech.DemoAppOrionTech.model.Employees;
import com.skill.check.orion.tech.DemoAppOrionTech.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose de leon on 3/23/2021.
 */
@Controller
public class BusinessDetailPageController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping(value = "/business/detail/{businessId}", method = RequestMethod.GET)
    public String viewDetailBusiness(@PathVariable("businessId") Long businessId , Model model){

        Business businessBean = businessService.findById(businessId);

        List<Employees> listEmployees = new ArrayList<>();

        for (Employees b : businessBean.getEmployeesList() ){

            listEmployees.add(b);
        }

        model.addAttribute("listEmployees", listEmployees);

        model.addAttribute("businessBean", businessBean);

        return "BusinessDetailPage";
    }

}
