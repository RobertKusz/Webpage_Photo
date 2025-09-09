package org.photoclub.domain.webpages.homePage;

import org.photoclub.domain.webpages.homePage.dto.WebpageDto;

public class WebpageDtoMapper {
    static WebpageDto map (Webpage webpage){
        WebpageDto webpageDto = new WebpageDto();
        webpageDto.setFirstBackground(webpage.getFirstBackground());
        webpageDto.setIntroductionFirstLayer(webpage.getIntroductionFirstLayer());
        webpageDto.setIntroductionSecondLayer(webpage.getIntroductionSecondLayer());
        webpageDto.setPhotographerPhoto(webpage.getPhotographerPhoto());
        webpageDto.setDescriptionFirstLayer(webpage.getDescriptionFirstLayer());
        webpageDto.setDescriptionSecondLayer(webpage.getDescriptionSecondLayer());
        webpageDto.setDescriptionThirdLayer(webpage.getDescriptionThirdLayer());
        webpageDto.setRollingPhoto(webpage.getRollingPhoto());
        webpageDto.setSessions(webpage.getSessions());

        return webpageDto;
    }
}
