package com.capgemini.craftsmanship.MapstructDemo.service;

import com.capgemini.craftsmanship.MapstructDemo.entity.PersonEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public PersonEntity findById(Long id) {
        PersonEntity person = new PersonEntity();
        person.setId(id);
        return person;
    }
}
