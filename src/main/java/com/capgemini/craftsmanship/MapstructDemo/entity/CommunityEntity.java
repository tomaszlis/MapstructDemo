package com.capgemini.craftsmanship.MapstructDemo.entity;

import javax.persistence.Entity;

@Entity
public class CommunityEntity extends AbstractEntity {

    /**
     * Name of the Community
     */
    private String name;

    /**
     * Coordinating person
     */
    private PersonEntity coordinator;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonEntity getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(PersonEntity coordinator) {
        this.coordinator = coordinator;
    }
}
