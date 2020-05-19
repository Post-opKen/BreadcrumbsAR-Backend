package com.breadcrumbsar.breadcrumbsbackend.services;

import com.breadcrumbsar.breadcrumbsbackend.models.Anchor;
import com.breadcrumbsar.breadcrumbsbackend.repositories.IAnchorRepository;
import org.springframework.stereotype.Service;

@Service
public class AnchorService
{
    IAnchorRepository iAnchorRepository;

    public AnchorService(IAnchorRepository iAnchorRepository)
    {
        this.iAnchorRepository = iAnchorRepository;
    }

    public boolean saveAnchor(Anchor anchor)
    {
        iAnchorRepository.save(anchor);
        return iAnchorRepository.existsByAnchorId(anchor.getAnchorId());
    }
}
