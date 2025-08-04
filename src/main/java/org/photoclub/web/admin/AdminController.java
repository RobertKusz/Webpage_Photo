package org.photoclub.web.admin;

import org.photoclub.domain.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class AdminController {
    private final UserService userService;
    public static final String NOTIFICATION_ATTRIBUTE = "";

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String getAdminPanel(Principal principal, Model model){
        Long userId = userService.findUserIdByEmail(principal.getName());
        model.addAttribute("userId", userId);
        return "admin/admin";
    }
}
