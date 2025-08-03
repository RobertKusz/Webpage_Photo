package org.photoclub.domain.webpage;

import org.photoclub.domain.webpage.dto.WebpageDto;
import org.springframework.stereotype.Service;

@Service
public class WebpageService {
    private final WebpageRepository webpageRepository;

    public WebpageService(WebpageRepository webpageRepository) {
        this.webpageRepository = webpageRepository;
    }

    public WebpageDto findWebpageById(Long webpageId) {
        return webpageRepository.findById(webpageId).map(WebpageDtoMapper::map).orElseThrow();
    }
}
