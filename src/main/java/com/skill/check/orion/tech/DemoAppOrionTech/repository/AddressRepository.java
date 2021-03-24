package com.skill.check.orion.tech.DemoAppOrionTech.repository;

import com.skill.check.orion.tech.DemoAppOrionTech.model.Address;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Entity;

/**
 * Created by jose de leon on 3/22/2021.
 */
public interface AddressRepository extends CrudRepository<Address, Long> {
}
