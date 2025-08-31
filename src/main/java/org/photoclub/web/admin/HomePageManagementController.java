package org.photoclub.web.admin;

import org.photoclub.domain.user.UserService;
import org.photoclub.domain.user.dto.UserHomepageDto;
import org.photoclub.domain.webpages.homePage.Webpage;
import org.photoclub.domain.webpages.homePage.WebpageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageManagementController {
    private final UserService userService;
    private final WebpageService webpageService;

    public HomePageManagementController(UserService userService, WebpageService webpageService) {
        this.userService = userService;
        this.webpageService = webpageService;
    }

    @GetMapping("/admin/{userId}/zarzadzaj_strona_glowna")
    String homePageManage(@PathVariable Long userId, Model model){
        UserHomepageDto userById = userService.findUserHomepageDtoById(userId);
        Webpage webpage = webpageService.findWebpageById(userById.getWebpageId());

        model.addAttribute("webpage", webpage);
        model.addAttribute("userId", userId);

        return "/admin/edit-home-page";
    }

    @PostMapping("/admin/{userId}/zarzadzaj_strona_glowna/{webpageId}/przedstawienie_pierwsza_linia")
    String changeIntroductionFirstLayer(@PathVariable Long userId,
                                        @PathVariable Long webpageId,
                                        @RequestParam String introductionFirstLayer){
        webpageService.changeIntroductionFirstLayer(webpageId, introductionFirstLayer);
        return "redirect:/admin/"+userId+"/zarzadzaj_strona_glowna";
    }

    @PostMapping("/admin/{userId}/zarzadzaj_strona_glowna/{webpageId}/przedstawienie_druga_linia")
    String changeIntroductionSecondLayer(@PathVariable Long userId,
                                        @PathVariable Long webpageId,
                                        @RequestParam String introductionSecondLayer){
        webpageService.changeIntroductionSecondLayer(webpageId, introductionSecondLayer);
        return "redirect:/admin/"+userId+"/zarzadzaj_strona_glowna";
    }


    @PostMapping("/admin/{userId}/zarzadzaj_strona_glowna/{webpageId}/opis_pierwsza_linia")
    String changeDescriptionFirstLayer(@PathVariable Long userId,
                                       @PathVariable Long webpageId,
                                       @RequestParam String descriptionFirstLayer){
        webpageService.changeDescriptionFirstLayer(webpageId, descriptionFirstLayer);
        return "redirect:/admin/"+userId+"/zarzadzaj_strona_glowna";
    }

    @PostMapping("/admin/{userId}/zarzadzaj_strona_glowna/{webpageId}/opis_druga_linia")
    String changeDescriptionSecondLayer(@PathVariable Long userId,
                                        @PathVariable Long webpageId,
                                        @RequestParam String descriptionSecondLayer){
        webpageService.changeDescriptionSecondLayer(webpageId, descriptionSecondLayer);
        return "redirect:/admin/"+userId+"/zarzadzaj_strona_glowna";
    }

    @PostMapping("/admin/{userId}/zarzadzaj_strona_glowna/{webpageId}/opis_trzecia_linia")
    String changeDescriptionThirdLayer(@PathVariable Long userId,
                                        @PathVariable Long webpageId,
                                        @RequestParam String descriptionThirdLayer){
        webpageService.changeDescriptionThirdLayer(webpageId, descriptionThirdLayer);
        return "redirect:/admin/"+userId+"/zarzadzaj_strona_glowna";
    }
}
