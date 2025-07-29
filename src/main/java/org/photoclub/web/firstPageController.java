package org.photoclub.web;

import org.photoclub.domain.user.UserService;
import org.photoclub.domain.user.dto.UserFirstPageDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        return "first_page";
    }
}
