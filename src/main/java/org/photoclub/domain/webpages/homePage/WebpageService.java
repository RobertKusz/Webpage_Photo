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

//        User user = userRepository.findById(userId).orElseThrow();
//        user.setHomePageId(webpage.getId());
//        userRepository.save(user);
    }

    @Transactional
    public void changeRollingPhoto(Long webpageId, MultipartFile file) {
        String filename = fileStorageService.saveImage(file);

        Webpage webpage = findWebpageById(webpageId);
        webpage.setRollingPhoto(filename);
        save(webpage);

//        User user = userRepository.findById(userId).orElseThrow();
//        user.setHomePageId(webpage.getId());
//        userRepository.save(user);

    }
}
