package com.breadcrumbsar.breadcrumbsbackend.models;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Message
{
    private long id;
    private String message;
    private String anchorId;
}
