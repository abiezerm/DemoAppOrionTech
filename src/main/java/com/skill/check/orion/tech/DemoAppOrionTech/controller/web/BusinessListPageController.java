package com.skill.check.orion.tech.DemoAppOrionTech.controller.web;

import com.skill.check.orion.tech.DemoAppOrionTech.model.Business;
import com.skill.check.orion.tech.DemoAppOrionTech.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose de leon on 3/23/2021.
 */
@Controller
public class BusinessListPageController {


    @Autowired
    private BusinessService businessService;

    @RequestMapping(value = "/business/list", method = RequestMethod.GET)
    public String viewListBusiness(Model model){


        Business[] array = businessService.findAll();
        List<Business> listbusiness = new ArrayList<>();

        for (Business b :array ){
            b. setOwnerName(b.getOwnerName() + " " + b.getOwnerSurname());
            listbusiness.add(b);
        }

        model.addAttribute("businessList", listbusiness);

        return "BusinessListPage";
    }

}
