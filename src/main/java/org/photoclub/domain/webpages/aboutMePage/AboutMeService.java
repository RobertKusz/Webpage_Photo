package org.photoclub.domain.webpages.aboutMePage;

import org.photoclub.domain.user.User;
import org.photoclub.domain.user.UserRepository;
import org.photoclub.domain.webpages.aboutMePage.dto.AboutMeDto;
import org.springframework.stereotype.Service;

@Service
public class AboutMeService {
    private final AboutMeRepository aboutMeRepository;
    private final UserRepository userRepository;

    public AboutMeService(AboutMeRepository aboutMeRepository, UserRepository userRepository) {
        this.aboutMeRepository = aboutMeRepository;
        this.userRepository = userRepository;
    }

    public AboutMeDto getAboutMePageContentByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Long aboutMePageId = user.getAboutMePageId();
        AboutMe aboutMe = aboutMeRepository.findById(aboutMePageId).orElseThrow();
        return AboutMeDtoMapper.map(aboutMe);
    }
}
