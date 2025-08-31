package org.photoclub.domain.webpages.homePage;

import org.photoclub.domain.webpages.homePage.dto.WebpageDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WebpageService {
    private final WebpageRepository webpageRepository;

    public WebpageService(WebpageRepository webpageRepository) {
        this.webpageRepository = webpageRepository;
    }

    public WebpageDto findWebpageDtoById(Long webpageId) {
        return webpageRepository.findById(webpageId).map(WebpageDtoMapper::map).orElseThrow();
    }
    public Webpage findWebpageById(Long webpageId) {
        return webpageRepository.findById(webpageId).orElseThrow();
    }
    @Transactional
    public void save(Webpage webpage) {
        webpageRepository.save(webpage);
    }

    public void changeIntroductionFirstLayer(Long webpageId, String introductionFirstLayer){
        Webpage webpage = findWebpageById(webpageId);
        webpage.setIntroductionFirstLayer(introductionFirstLayer);
        save(webpage);
    }

    public void changeIntroductionSecondLayer(Long webpageId, String introductionSecondLayer) {
        Webpage webpage = findWebpageById(webpageId);
        webpage.setIntroductionSecondLayer(introductionSecondLayer);
        save(webpage);
    }

    public void changeDescriptionFirstLayer(Long webpageId, String descriptionFirstLayer) {
        Webpage webpage = findWebpageById(webpageId);
        webpage.setDescriptionFirstLayer(descriptionFirstLayer);
        save(webpage);
    }
    public void changeDescriptionSecondLayer(Long webpageId, String descriptionSecondLayer) {
        Webpage webpage = findWebpageById(webpageId);
        webpage.setDescriptionSecondLayer(descriptionSecondLayer);
        save(webpage);
    }

    public void changeDescriptionThirdLayer(Long webpageId, String descriptionThirdLayer) {
        Webpage webpage = findWebpageById(webpageId);
        webpage.setDescriptionThirdLayer(descriptionThirdLayer);
        save(webpage);
    }
}
