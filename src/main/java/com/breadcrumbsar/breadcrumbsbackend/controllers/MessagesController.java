package com.breadcrumbsar.breadcrumbsbackend.controllers;

import com.breadcrumbsar.breadcrumbsbackend.models.Message;
import com.breadcrumbsar.breadcrumbsbackend.models.SaveMessageResponse;
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
    @PutMapping("saveMessage")
    public void saveMessage(@RequestBody SaveMessageResponse response)
    {
        Message newMessage = new Message(0, response.getMessage(), response.getAnchorId());
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
