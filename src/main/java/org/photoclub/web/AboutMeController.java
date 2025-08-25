package org.photoclub.web;

import org.photoclub.domain.user.UserService;
import org.photoclub.domain.user.dto.UserHomepageDto;
import org.photoclub.domain.webpages.aboutMePage.AboutMeService;
import org.photoclub.domain.webpages.aboutMePage.dto.AboutMeDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AboutMeController {
    private final AboutMeService aboutMeService;
    private final UserService userService;

    public AboutMeController(AboutMeService aboutMeService, UserService userService) {
        this.aboutMeService = aboutMeService;
        this.userService = userService;
    }

    @GetMapping("/{id}/o_mnie")
    String loadAboutMePage(@PathVariable Long id, Model model){
        AboutMeDto aboutMePageContent = aboutMeService.getAboutMePageContentByUserId(id);
        UserHomepageDto userById = userService.findUserById(id);

        model.addAttribute("content", aboutMePageContent);
        model.addAttribute("photograph", userById);

        return "about_me";
    }
}
