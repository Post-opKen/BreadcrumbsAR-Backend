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
    private final double MAP_GEOFENCE = 0.005;
    private final double AR_GEOFENCE = 0.0005;

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
        double minLat = lattitude - MAP_GEOFENCE;
        double maxLat = lattitude + MAP_GEOFENCE;
        double minLong = longitude - MAP_GEOFENCE;
        double maxLong = longitude + MAP_GEOFENCE;
        List<Anchor> anchors = iAnchorRepository.findAnchorsByLattitudeBetweenAndLongitudeBetween(minLat, maxLat, minLong, maxLong);
        GetAnchorResponse response = new GetAnchorResponse(anchors);

        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<GetAnchorResponse> jsonAdapter = moshi.adapter(GetAnchorResponse.class);

        String json = jsonAdapter.toJson(response);
        return json;
    }

    public String getARAnchors(double lattitude, double longitude)
    {
        double minLat = lattitude - AR_GEOFENCE;
        double maxLat = lattitude + AR_GEOFENCE;
        double minLong = longitude - AR_GEOFENCE;
        double maxLong = longitude + AR_GEOFENCE;
        List<Anchor> anchors = iAnchorRepository.findAnchorsByLattitudeBetweenAndLongitudeBetween(minLat, maxLat, minLong, maxLong);
        GetAnchorResponse response = new GetAnchorResponse(anchors);

        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<GetAnchorResponse> jsonAdapter = moshi.adapter(GetAnchorResponse.class);

        String json = jsonAdapter.toJson(response);
        return json;
    }
}
