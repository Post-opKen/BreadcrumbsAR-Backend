package com.breadcrumbsar.breadcrumbsbackend.repositories;

import com.breadcrumbsar.breadcrumbsbackend.models.Anchor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnchorRepository extends CrudRepository<Anchor, Long>
{
    boolean existsByAnchorId(String anchorId);
}
