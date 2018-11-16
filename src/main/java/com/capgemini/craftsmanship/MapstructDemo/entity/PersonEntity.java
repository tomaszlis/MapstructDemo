package com.capgemini.craftsmanship.MapstructDemo.entity;

import com.capgemini.craftsmanship.MapstructDemo.type.Position;
import javafx.geometry.Pos;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class PersonEntity extends AbstractEntity {

    private String firstName;

    private String surname;

    private Position position;

    private String department;

    private LocalDateTime lastUpdateTime;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
