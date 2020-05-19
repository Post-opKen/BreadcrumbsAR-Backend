package com.breadcrumbsar.breadcrumbsbackend.repositories;


import com.breadcrumbsar.breadcrumbsbackend.models.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRepository extends CrudRepository<Message, Long>
{
    boolean existsByAnchorId(String anchorId);
}
