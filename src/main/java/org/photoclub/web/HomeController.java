package org.photoclub.web;

import org.photoclub.domain.session.SessionService;
import org.photoclub.domain.session.dto.SessionDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final SessionService sessionService;

    public HomeController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<SessionDto> allPromotedAndWeedingSessions = sessionService.findAllPromotedSessionsByType("weeding");
        model.addAttribute("weedingSessions", allPromotedAndWeedingSessions);

        List<SessionDto> allPromotedAndLandscapeSessions = sessionService.findAllPromotedSessionsByType("landscape");
        model.addAttribute("landscapeSessions", allPromotedAndLandscapeSessions);
        return "home-page";
    }
}
