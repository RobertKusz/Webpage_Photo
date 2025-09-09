package org.photoclub.domain.user;

import org.photoclub.domain.user.dto.*;
import org.photoclub.domain.webpages.aboutMePage.AboutMe;
import org.photoclub.domain.webpages.contactPage.Contact;
import org.photoclub.domain.webpages.homePage.Webpage;
import org.photoclub.domain.webpages.homePage.WebpageRepository;
import org.photoclub.domain.webpages.homePage.WebpageService;
import org.photoclub.domain.webpages.portfolioPage.Portfolio;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    final static public String DEFAULT_LOGO_FILENAME = "empty-logo.png";
    final static public String DEFAULT_MINIATURE_FILENAME = "empty_img.jpg";
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final WebpageService webpageService;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, WebpageService webpageService) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.webpageService = webpageService;
    }
    public Optional<UserCredentialsDto> findCredentialsByEmail(String email){
        return userRepository.findByEmail(email)
                .map(user -> UserDtoMapper.map(user));
    }

    public List<UserFirstPageDto> getListOfAllByRole(String role) {
        return userRepository.findByRoles_name(role)
                .stream()
                .map(Optional::orElseThrow)
                .map(UserDtoMapper::mapToFirstPage)
                .collect(Collectors.toList());
    }

    public UserHomepageDto findUserByEmail(String userEmail) {
        UserHomepageDto userHomepageDto = userRepository.findByEmail(userEmail).map(UserDtoMapper::mapToHomepage).orElseThrow();
        return userHomepageDto;
    }

    public UserHomepageDto findUserHomepageDtoById(Long id) {
        UserHomepageDto userHomepageDto = userRepository.findById(id).map(UserDtoMapper::mapToHomepage).orElseThrow();
        return userHomepageDto;
    }
    public Long findUserIdByEmail(String userEmail){
        return findUserByEmail(userEmail).getId();
    }

    public void registerUserWithDefaultRole(UserRegistrationDto userRegistrationDto){
        UserRole defaultRole = userRoleRepository.findByName("USER").orElseThrow();
        User user = new User();
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        user.getRoles().add(defaultRole);
        userRepository.save(user);
    }
    public void registerUserWithPhotographRole(PhotographRegistrationDto photographRegistrationDto){
        UserRole photographRole = userRoleRepository.findByName("PHOTOGRAPH").orElseThrow();
        User user = new User();
        user.setEmail(photographRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(photographRegistrationDto.getPassword()));
        user.setFirstName(photographRegistrationDto.getFirstName());
        user.setLastName(photographRegistrationDto.getLastName());
        user.getRoles().add(photographRole);
        user.setPhotographingType(photographRegistrationDto.getPhotographingType());
        user.setLogoHomeFilename(DEFAULT_LOGO_FILENAME);
        user.setMiniatureFilename(DEFAULT_MINIATURE_FILENAME);

        AboutMe aboutMe = new AboutMe();
        Webpage webpage = new Webpage();
        webpageService.fillDefaultAndSave(webpage);
        Contact contact = new Contact();
        Portfolio portfolio = new Portfolio();


        user.setAboutMePageId(aboutMe.getId());
        user.setHomePageId(webpage.getId());
        user.setContactPageId(contact.getId());
        user.setPortfolioPageId(portfolio.getId());


        userRepository.save(user);
    }
}
