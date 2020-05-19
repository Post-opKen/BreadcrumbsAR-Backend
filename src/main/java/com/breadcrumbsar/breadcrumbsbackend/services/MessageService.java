package com.breadcrumbsar.breadcrumbsbackend.services;

import com.breadcrumbsar.breadcrumbsbackend.models.Anchor;
import com.breadcrumbsar.breadcrumbsbackend.models.Message;
import com.breadcrumbsar.breadcrumbsbackend.repositories.IMessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService
{
    private IMessageRepository iMessageRepository;

    public MessageService(IMessageRepository iMessageRepository)
    {
        this.iMessageRepository = iMessageRepository;
    }

    public boolean saveMessage(Message message)
    {
        iMessageRepository.save(message);
        //search by anchor id because the message id isn't set yet
        return iMessageRepository.existsByAnchorId(message.getAnchorId());
    }
}
