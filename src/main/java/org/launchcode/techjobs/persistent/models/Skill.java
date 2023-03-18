package org.launchcode.techjobs.persistent.models;

import jdk.jfr.Description;

import javax.persistence.Entity;

@Entity
public class Skill extends AbstractEntity {


    public String description;
}