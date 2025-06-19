package org.photoclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionsController {
    @GetMapping("/sesje")
    public String sessionPage(){
        return "sessions";
    }
}
