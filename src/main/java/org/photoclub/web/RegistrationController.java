package org.photoclub.web;

import org.photoclub.domain.user.UserService;
import org.photoclub.domain.user.dto.PhotographRegistrationDto;
import org.photoclub.domain.user.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    //napisać strone do rejestracji, po lewej rejestracja urzytkownika po prawej fotografa każdy w osobnym formularzu pipsać z kursem javastart

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/rejestracja")
    String registrationForm(Model model){
        UserRegistrationDto userDto = new UserRegistrationDto();
        PhotographRegistrationDto photographDto = new PhotographRegistrationDto();
        model.addAttribute("user", userDto);
        model.addAttribute("photograph", photographDto);
        return "registration";
    }

    @PostMapping("rejestracja/uzytkownik")
    String userRegistration(UserRegistrationDto userRegistrationDto){
        userService.registerUserWithDefaultRole(userRegistrationDto);
        return "redirect:/first";
    }
    @PostMapping("rejestracja/fotograf")
    String userRegistration(PhotographRegistrationDto photographRegistration){
        userService.registerUserWithPhotographRole(photographRegistration);
        return "redirect:/first";
    }
}
