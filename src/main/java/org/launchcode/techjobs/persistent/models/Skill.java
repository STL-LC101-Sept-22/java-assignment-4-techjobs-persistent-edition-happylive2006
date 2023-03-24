package org.launchcode.techjobs.persistent.models;

import jdk.jfr.Description;

import javax.persistence.Entity;

@Entity
public class Skill extends AbstractEntity {
    public String description;

    public Skill() {}

    public Skill(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}