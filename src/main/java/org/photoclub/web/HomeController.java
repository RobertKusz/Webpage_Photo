package org.photoclub.web;

import org.photoclub.domain.session.SessionDtoMapper;
import org.photoclub.domain.session.SessionService;
import org.photoclub.domain.session.dto.SessionDto;
import org.photoclub.domain.user.UserService;
import org.photoclub.domain.user.dto.UserHomepageDto;
import org.photoclub.domain.webpages.homePage.WebpageService;
import org.photoclub.domain.webpages.homePage.dto.WebpageDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final UserService userService;
    private final SessionService sessionService;
    private final WebpageService webpageService;

    public HomeController(UserService user, SessionService sessionService, WebpageService webpageService) {
        this.userService = user;
        this.sessionService = sessionService;
        this.webpageService = webpageService;
    }

    @GetMapping("/{id}")
    public String home(Model model, @PathVariable Long id){
        UserHomepageDto userById = userService.findUserById(id);
        WebpageDto webpage = webpageService.findWebpageDtoById(userById.getWebpageId());

        List<SessionDto> sessionDtos = webpage.getSessions().stream()
                .map(SessionDtoMapper::map)
                .toList();

        Map<String, List<SessionDto>> sessionsByType = sessionDtos.stream()
                .collect(Collectors.groupingBy(SessionDto::getSessionType));
        model.addAttribute("sessionsByType", sessionsByType);
        model.addAttribute("webpage", webpage);
        model.addAttribute("photograph", userById);
        return "home-page";
    }
}
