package com.skill.check.orion.tech.DemoAppOrionTech.controller.web;

import com.skill.check.orion.tech.DemoAppOrionTech.beans.BusinessBean;
import com.skill.check.orion.tech.DemoAppOrionTech.beans.EmployeeBean;
import com.skill.check.orion.tech.DemoAppOrionTech.model.Address;
import com.skill.check.orion.tech.DemoAppOrionTech.model.Business;
import com.skill.check.orion.tech.DemoAppOrionTech.model.Employees;
import com.skill.check.orion.tech.DemoAppOrionTech.service.BusinessService;
import com.skill.check.orion.tech.DemoAppOrionTech.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jose de leon on 3/23/2021.
 */
@Controller
public class EmployeesRegistrationPageController {

    @Autowired
    private EmployeeBean employeeBean;

    @Autowired
    private BusinessService businessService;


    @Autowired
    private EmployeesService employeesService;

    @RequestMapping(value = "/business/registration/employees/{businessId}", method = RequestMethod.GET)
    public String viewRegistrationBusinessEmployees(@PathVariable("businessId") Long businessId , Model model){


        Business businessBean = businessService.findById(businessId);

        model.addAttribute("businessBean", businessBean);
        model.addAttribute("employeeBean", employeeBean);

        return "RegistrationEmployees";
    }

    @RequestMapping(value = "/register/employee/business/{businessId}", method = RequestMethod.POST)
    public String registerBusiness(@ModelAttribute(value="employeeData") EmployeeBean employeeBean, @PathVariable("businessId") String businessId ,Model model){

        long businessIdN =Integer.parseInt(businessId);

        Employees emp = new Employees();

        emp.setName(employeeBean.getName());
        emp.setLastName(employeeBean.getLastName());
        emp.setEmployeeCode(employeeBean.getEmployeeCode());

        if(employeeBean.getAddressOne() != null && employeeBean.getAddressOne() != "" ){

            emp.getAddress().add(new Address(employeeBean.getAddressOne()));
        }

        if(employeeBean.getAddressTwo() != null && employeeBean.getAddressTwo() != "" ){

            emp.getAddress().add(new Address(employeeBean.getAddressTwo()));
        }

        if(employeeBean.getAddressThree() != null && employeeBean.getAddressThree() != "" ){

            emp.getAddress().add(new Address(employeeBean.getAddressThree()));
        }

        employeesService.addEmployee(businessIdN, emp);

        return "redirect:/business/detail/"+businessId;
    }


}
