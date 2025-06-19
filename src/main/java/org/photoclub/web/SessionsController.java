package org.photoclub.web;

import org.photoclub.domain.session.Session;
import org.photoclub.domain.session.SessionService;
import org.photoclub.domain.session.dto.SessionDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SessionsController {
    private final SessionService sessionService;

    public SessionsController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/sesje")
    public String sessionPage(Model model){
        List<SessionDto> allSessions = sessionService.getAllSessions();
        model.addAttribute("allSessions", allSessions);
        return "sessions";
    }



}
