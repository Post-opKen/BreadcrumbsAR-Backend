package com.breadcrumbsar.breadcrumbsbackend.controllers;

import com.breadcrumbsar.breadcrumbsbackend.models.Message;
import com.breadcrumbsar.breadcrumbsbackend.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessagesController
{
    @Autowired
    private MessageService messageService;

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping("saveMessage")
    public void saveMessage(@RequestParam(name = "anchorId") String anchorId, @RequestParam(name = "message") String message)
    {
        Message newMessage = new Message(0, message, anchorId);
        messageService.saveMessage(newMessage);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("getMessage")
    public String getMessageByAnchor(@RequestParam(name = "anchorId") String anchorId)
    {
        String json = messageService.getMessage(anchorId);
        return json;
    }
}
