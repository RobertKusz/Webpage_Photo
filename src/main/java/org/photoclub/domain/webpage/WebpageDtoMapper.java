package org.photoclub.domain.webpage;

import org.photoclub.domain.session.SessionDtoMapper;
import org.photoclub.domain.webpage.dto.WebpageDto;

import java.util.stream.Collectors;

public class WebpageDtoMapper {
    static WebpageDto map (Webpage webpage){
        WebpageDto webpageDto = new WebpageDto();
        webpageDto.setFirstBackground(webpage.getFirstBackground());
        webpageDto.setIntroductionFirstLayer(webpage.getIntroductionFirstLayer());
        webpageDto.setIntroductionSecondLayer(webpage.getDescriptionSecondLayer());
        webpageDto.setPhotographerPhoto(webpage.getPhotographerPhoto());
        webpageDto.setDescriptionFirstLayer(webpage.getDescriptionFirstLayer());
        webpageDto.setDescriptionSecondLayer(webpage.getIntroductionSecondLayer());
        webpageDto.setDescriptionThirdLayer(webpage.getDescriptionThirdLayer());
        webpageDto.setRollingPhoto(webpage.getRollingPhoto());
        webpageDto.setSessions(webpage.getSessions());
        return webpageDto;
    }
}
