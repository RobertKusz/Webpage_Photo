package org.photoclub.web.admin;

import org.photoclub.domain.user.UserService;
import org.photoclub.domain.user.dto.UserHomepageDto;
import org.photoclub.domain.webpages.homePage.Webpage;
import org.photoclub.domain.webpages.homePage.WebpageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomePageManagement {
    private final UserService userService;
    private final WebpageService webpageService;

    public HomePageManagement(UserService userService, WebpageService webpageService) {
        this.userService = userService;
        this.webpageService = webpageService;
    }

    @GetMapping("/admin/{userId}/zarzadzaj_strona_glowna")
    String homePageManage(@PathVariable Long userId, Model model){
        UserHomepageDto userById = userService.findUserHomepageDtoById(userId);
        Webpage webpage = webpageService.findWebpageById(userById.getWebpageId());

        model.addAttribute("webpage", webpage);

        return "/admin/edit-home-page";
    }
}
