package com.breadcrumbsar.breadcrumbsbackend.controllers;

import com.breadcrumbsar.breadcrumbsbackend.models.Anchor;
import com.breadcrumbsar.breadcrumbsbackend.services.AnchorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@ResponseBody
public class AnchorsController
{
    @Autowired
    private AnchorService anchorService;

    @ResponseStatus(code= HttpStatus.OK)
    @GetMapping("saveAnchor")
    public void saveAnchor(@RequestParam(name = "id") String anchorId,
                             @RequestParam(name = "lat") double lattitude,
                             @RequestParam(name = "long") double longitude)
    {
        Anchor anchor = new Anchor(anchorId, lattitude, longitude);
        anchorService.saveAnchor(anchor);
    }

    @ResponseStatus(code= HttpStatus.OK)
    @GetMapping("getAnchors")
    public String getAnchorsByCoords(@RequestParam(name = "lat") double lattitude,
                                     @RequestParam(name = "long") double longitude)
    {
        String json = anchorService.getMapAnchors(lattitude, longitude);
        return json;
    }
}
