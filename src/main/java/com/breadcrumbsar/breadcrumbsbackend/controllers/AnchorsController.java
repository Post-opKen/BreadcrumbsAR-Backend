package com.breadcrumbsar.breadcrumbsbackend.controllers;

import com.breadcrumbsar.breadcrumbsbackend.models.Anchor;
import com.breadcrumbsar.breadcrumbsbackend.models.SaveAnchorResponse;
import com.breadcrumbsar.breadcrumbsbackend.services.AnchorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class AnchorsController
{
    @Autowired
    private AnchorService anchorService;

    @ResponseStatus(code= HttpStatus.OK)
    @PutMapping("saveAnchor")
    public void saveAnchor(@RequestBody SaveAnchorResponse response)
    {
        Anchor anchor = new Anchor(response.getId(), response.getLat(), response.getLon());
        anchorService.saveAnchor(anchor);
    }

    @ResponseStatus(code= HttpStatus.OK)
    @GetMapping("getMapAnchors")
    public String getMapAnchors(@RequestParam(name = "lat") double lattitude,
                                     @RequestParam(name = "long") double longitude)
    {
        String json = anchorService.getMapAnchors(lattitude, longitude);
        return json;
    }

    @ResponseStatus(code= HttpStatus.OK)
    @GetMapping("getARAnchors")
    public String getARAnchors(@RequestParam(name = "lat") double lattitude,
                                     @RequestParam(name = "long") double longitude)
    {
        String json = anchorService.getARAnchors(lattitude, longitude);
        return json;
    }
}
