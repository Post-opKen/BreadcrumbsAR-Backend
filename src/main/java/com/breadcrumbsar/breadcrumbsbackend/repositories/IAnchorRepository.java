package com.breadcrumbsar.breadcrumbsbackend.repositories;

import com.breadcrumbsar.breadcrumbsbackend.models.Anchor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAnchorRepository extends CrudRepository<Anchor, Long>
{
    boolean existsByAnchorId(String anchorId);
    List<Anchor> findAnchorsByLattitudeBetweenAndLongitudeBetween
            (double minLat, double maxlat, double minLong, double maxLong);
}
