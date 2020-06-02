package com.breadcrumbsar.breadcrumbsbackend.models;

import java.util.List;

public class GetAnchorResponse
{
    private List<Anchor> anchorList;

    public GetAnchorResponse(List<Anchor> anchorList)
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
