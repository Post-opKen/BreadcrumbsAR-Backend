package com.breadcrumbsar.breadcrumbsbackend.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagesController
{
    public String messageByID(String id)
    {
        return "This is a message!";
    }
}
