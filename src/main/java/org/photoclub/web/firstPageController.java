package org.photoclub.web;

import org.photoclub.domain.user.PhotoType;
import org.photoclub.domain.user.UserService;
import org.photoclub.domain.user.dto.UserFirstPageDto;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class firstPageController {
    private final UserService userService;

    public firstPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/first")
    String getFirstPAge(Model model){
        List<UserFirstPageDto> photographs = userService.getListOfAllByRole("PHOTOGRAPH");
        model.addAttribute("photographs", photographs);
        model.addAttribute("photoTypes", PhotoType.allTypesWithAllOption());
        return "first_page";
    }

    @PostMapping("/first")
    String sortPhotographers(@RequestParam("photoType") String photoType, Model model){
        List<UserFirstPageDto> usersByType = userService.findByPhotographingType(photoType);
        model.addAttribute("photographs", usersByType);
        model.addAttribute("photoTypes", PhotoType.allTypesWithAllOption());
        System.out.println("photoType"+photoType);
        return "first_page";
    }
}