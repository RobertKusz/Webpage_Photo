package org.photoclub.domain.webpages.homePage;

import org.photoclub.domain.user.User;
import org.photoclub.domain.user.UserDtoMapper;
import org.photoclub.domain.user.UserRepository;
import org.photoclub.domain.webpages.homePage.dto.WebpageDto;
import org.photoclub.storage.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class WebpageService {
    final String DEFAULT_BACKGROUND = "background.webp";
    final String DEFAULT_ROLLING_BACKGROUND="rolling_background1.jpg";
    final String DEFAULT_PHOTOGRAPH_PHOTO="photograph.jpg";
    private final WebpageRepository webpageRepository;
    private final FileStorageService fileStorageService;
    private final UserRepository userRepository;
    public WebpageService(WebpageRepository webpageRepository, FileStorageService fileStorageService, UserRepository userRepository) {
        this.webpageRepository = webpageRepository;
        this.fileStorageService = fileStorageService;
        this.userRepository = userRepository;
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
    @Transactional
    public void changeFirstBackground(Long webpageId, MultipartFile file) {
        String filename = fileStorageService.saveImage(file);

        Webpage webpage = findWebpageById(webpageId);
        webpage.setFirstBackground(filename);
        save(webpage);
    }

    @Transactional
    public void changeRollingPhoto(Long webpageId, MultipartFile file) {
        String filename = fileStorageService.saveImage(file);

        Webpage webpage = findWebpageById(webpageId);
        webpage.setRollingPhoto(filename);
        save(webpage);
    }

    public void fillDefaultAndSave(Webpage webpage) {
        webpage.setFirstBackground(DEFAULT_BACKGROUND);
        webpage.setRollingPhoto(DEFAULT_ROLLING_BACKGROUND);
        webpage.setPhotographerPhoto(DEFAULT_PHOTOGRAPH_PHOTO);

        webpage.setIntroductionFirstLayer("Jaki typ fotografii ");
        webpage.setIntroductionSecondLayer("Przedstaw się");

        webpage.setDescriptionFirstLayer("Opis 1");
        webpage.setDescriptionSecondLayer("Opis 2");
        webpage.setDescriptionThirdLayer("Opis 3");


        save(webpage);
    }
}
