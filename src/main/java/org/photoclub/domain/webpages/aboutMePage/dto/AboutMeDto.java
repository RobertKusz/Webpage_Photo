package org.photoclub.domain.webpages.aboutMePage.dto;

import java.util.List;

public class AboutMeDto {
    private List<String> shortDescription;
    private List<String> longDescription;

    public List<String> getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(List<String> shortDescription) {
        this.shortDescription = shortDescription;
    }

    public List<String> getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(List<String> longDescription) {
        this.longDescription = longDescription;
    }
}
