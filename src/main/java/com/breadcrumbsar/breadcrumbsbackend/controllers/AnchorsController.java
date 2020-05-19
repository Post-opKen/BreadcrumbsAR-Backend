package com.breadcrumbsar.breadcrumbsbackend.controllers;

import com.breadcrumbsar.breadcrumbsbackend.models.Anchor;
import com.breadcrumbsar.breadcrumbsbackend.services.AnchorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class AnchorsController
{
    @Autowired
    private AnchorService anchorService;

    @GetMapping("saveAnchor")
    public String saveAnchor(@RequestParam(name = "id") String anchorId,
                             @RequestParam(name = "lat") double lattitude,
                             @RequestParam(name = "long") double longitude)
    {
        Anchor anchor = new Anchor(anchorId, lattitude, longitude);

        if(anchorService.saveAnchor(anchor))
        {
            return "Success!";
        }else
        {
            return "Failed!";
        }
    }

    public String getAnchorsByCoords()
    {
        return "";
    }
}
