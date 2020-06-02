package com.breadcrumbsar.breadcrumbsbackend.services;

import com.breadcrumbsar.breadcrumbsbackend.models.Message;
import com.breadcrumbsar.breadcrumbsbackend.repositories.IMessageRepository;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class MessageService
{
    private IMessageRepository iMessageRepository;

    public MessageService(IMessageRepository iMessageRepository)
    {
        this.iMessageRepository = iMessageRepository;
    }

    public void saveMessage(Message message)
    {
        iMessageRepository.save(message);
        if (!iMessageRepository.existsByAnchorId(message.getAnchorId()))
        {
            throw new RuntimeException("Message failed to save");
        }
    }

    public String getMessage(String anchorId)
    {
        Optional<Message> response = iMessageRepository.findByAnchorId(anchorId);
        if(response.isPresent())
        {
            Message message = response.get();
            Moshi moshi = new Moshi.Builder().build();
            JsonAdapter<Message> jsonAdapter = moshi.adapter(Message.class);

            String json = jsonAdapter.toJson(message);
            return json;
        }
        else{
            throw new InvalidParameterException("Anchor id not found");
        }
    }

}
