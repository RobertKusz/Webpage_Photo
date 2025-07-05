package org.photoclub.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    public static final String NOTIFICATION_ATTRIBUTE = "";

    @GetMapping("/admin")
    public String getAdminPanel(){
        return "admin/admin";
    }
}
