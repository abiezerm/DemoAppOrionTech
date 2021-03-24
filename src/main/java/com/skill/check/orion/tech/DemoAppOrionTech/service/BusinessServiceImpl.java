package com.skill.check.orion.tech.DemoAppOrionTech.service;

import com.skill.check.orion.tech.DemoAppOrionTech.model.Business;
import com.skill.check.orion.tech.DemoAppOrionTech.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

/**
 * Created by jose de leon on 3/22/2021.
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    @Override
    public Business saveOrUpdateBusiness(Business business) {
        return businessRepository.save(business);
    }

    @Override
    public Business[] findAll() {
        Iterable<Business> list = businessRepository.findAll();
        Business[] array = StreamSupport.stream(list.spliterator(), false).toArray(Business[]::new);
        return array;
    }

    @Override
    public Business findById(long id) {
        return businessRepository.findById(id).get();
    }
}
