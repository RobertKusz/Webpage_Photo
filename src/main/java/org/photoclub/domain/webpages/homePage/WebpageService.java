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
}
