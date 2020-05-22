package com.breadcrumbsar.breadcrumbsbackend.models;

import java.util.List;

public class AnchorResponse
{
    private List<Anchor> anchorList;

    public AnchorResponse(List<Anchor> anchorList)
    {
        this.anchorList = anchorList;
    }

    public List<Anchor> getAnchorList()
    {
        return anchorList;
    }

    public void setAnchorList(List<Anchor> anchorList)
    {
        this.anchorList = anchorList;
    }
}
