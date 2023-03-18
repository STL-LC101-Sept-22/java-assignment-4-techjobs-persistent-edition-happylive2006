package org.launchcode.techjobs.persistent.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.stream.Location;

public class Employer extends AbstractEntity {
    @NotBlank
    @Size(max=100)
    @NotNull
    public String location;




}
