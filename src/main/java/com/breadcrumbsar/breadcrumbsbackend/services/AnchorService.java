package com.breadcrumbsar.breadcrumbsbackend.services;

import com.breadcrumbsar.breadcrumbsbackend.models.Anchor;
import com.breadcrumbsar.breadcrumbsbackend.models.GetAnchorResponse;
import com.breadcrumbsar.breadcrumbsbackend.repositories.IAnchorRepository;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnchorService
{
    private final double GEOFENCE = 0.001;

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
        double minLat = lattitude - GEOFENCE;
        double maxLat = lattitude + GEOFENCE;
        double minLong = longitude - GEOFENCE;
        double maxLong = longitude + GEOFENCE;
        List<Anchor> anchors = iAnchorRepository.findAnchorsByLattitudeBetweenAndLongitudeBetween(minLat, maxLat, minLong, maxLong);
        GetAnchorResponse response = new GetAnchorResponse(anchors);

        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<GetAnchorResponse> jsonAdapter = moshi.adapter(GetAnchorResponse.class);

        String json = jsonAdapter.toJson(response);
        return json;
    }
}
