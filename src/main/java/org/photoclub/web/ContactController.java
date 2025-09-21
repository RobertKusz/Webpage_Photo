package org.photoclub.web;

import org.photoclub.domain.user.UserService;
import org.photoclub.domain.user.dto.UserHomepageDto;
import org.photoclub.domain.webpages.homePage.WebpageService;
import org.photoclub.domain.webpages.homePage.dto.WebpageDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ContactController {
    private final UserService userService;
    private final WebpageService webpageService;

    public ContactController(UserService userService, WebpageService webpageService) {
        this.userService = userService;
        this.webpageService = webpageService;
    }

    @GetMapping("/{id}/kontakt")
    String getContactPage(@PathVariable Long id, Model model){
        UserHomepageDto userById = userService.findUserHomepageDtoById(id);
        WebpageDto webpage = webpageService.findWebpageDtoById(userById.getWebpageId());

        model.addAttribute("webpage", webpage);
        model.addAttribute("photograph", userById);

        return "contact";
    }
}