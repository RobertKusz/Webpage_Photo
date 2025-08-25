package org.photoclub.domain.webpages.aboutMePage;

import org.photoclub.domain.webpages.aboutMePage.dto.AboutMeDto;

public class AboutMeDtoMapper {
    static AboutMeDto map(AboutMe aboutMe){
        AboutMeDto aboutMeDto = new AboutMeDto();
        aboutMeDto.setShortDescription(aboutMe.getShortDescription());
        aboutMeDto.setLongDescription(aboutMe.getLongDescription());
        return aboutMeDto;
    }
}
