package com.breadcrumbsar.breadcrumbsbackend.models;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Anchor
{
    private String anchorId;
    private double lattitude;
    private double longitude;
}
