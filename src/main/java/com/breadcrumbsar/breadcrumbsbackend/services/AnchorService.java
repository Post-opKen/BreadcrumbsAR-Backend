package com.breadcrumbsar.breadcrumbsbackend.services;

import com.breadcrumbsar.breadcrumbsbackend.models.Anchor;
import com.breadcrumbsar.breadcrumbsbackend.models.AnchorResponse;
import com.breadcrumbsar.breadcrumbsbackend.repositories.IAnchorRepository;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnchorService
{
    private final double MAP_RANGE = 0.001;
    private final double AR_RANGE =  0.00001;
    IAnchorRepository iAnchorRepository;

    public AnchorService(IAnchorRepository iAnchorRepository)
    {
        this.iAnchorRepository = iAnchorRepository;
    }

    public void saveAnchor(Anchor anchor)
    {
        iAnchorRepository.save(anchor);
        if(!iAnchorRepository.existsByAnchorId(anchor.getAnchorId()))
        {
            throw new RuntimeException("Anchor failed to save");
        }
    }

    public String getMapAnchors(double lattitude, double longitude)
    {
        double minLat = lattitude - MAP_RANGE;
        double maxLat = lattitude + MAP_RANGE;
        double minLong = longitude - MAP_RANGE;
        double maxLong = longitude + MAP_RANGE;
        List<Anchor> anchors = iAnchorRepository.findAnchorsByLattitudeBetweenAndLongitudeBetween(minLat, maxLat, minLong, maxLong);
        AnchorResponse response = new AnchorResponse(anchors);

        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<AnchorResponse> jsonAdapter = moshi.adapter(AnchorResponse.class);

        String json = jsonAdapter.toJson(response);
        return json;
    }

    public String getNearestAnchor()
    {
        return "";
    }
}
