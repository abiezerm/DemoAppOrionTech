package com.skill.check.orion.tech.DemoAppOrionTech.controller.web;

import com.skill.check.orion.tech.DemoAppOrionTech.beans.BusinessBean;
import com.skill.check.orion.tech.DemoAppOrionTech.model.Business;
import com.skill.check.orion.tech.DemoAppOrionTech.service.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jose de leon on 3/23/2021.
 */
@Controller
public class BusinessRegistrationPageController {


    Logger logger = LoggerFactory.getLogger(BusinessRegistrationPageController.class);

    @Autowired
    private BusinessBean businessBean;

    @Autowired
    private BusinessService businessService;

    @RequestMapping(value = {"/business/registration", "/"}, method = RequestMethod.GET)
    public String viewRegistrationBusiness(Model model){

        model.addAttribute("businessBean", businessBean);

        return "RegistrationBusiness";
    }



    @RequestMapping(value = "/register/business", method = RequestMethod.POST)
    public String registerBusiness(@ModelAttribute(value="businessData") BusinessBean businessBean, Model model){
        logger.info("error en la autenticacion status: ");

        Business bus = new Business();

        bus.setName(businessBean.getBusinessName());
        bus.setEmail(businessBean.getEmail());
        bus.setRnc(businessBean.getRnc());
        bus.setOwnerName(businessBean.getOwnerName());
        bus.setOwnerSurname(businessBean.getOwnerSurname());

        businessService.saveOrUpdateBusiness(bus);

        return "redirect:/business/list";
    }

}
