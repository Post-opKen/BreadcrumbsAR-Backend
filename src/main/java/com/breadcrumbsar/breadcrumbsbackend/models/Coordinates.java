package com.breadcrumbsar.breadcrumbsbackend.models;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Coordinates
{
    private long id;
    private double lattitude;
    private double longitude;
    private String anchorId;
}
