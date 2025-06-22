package org.photoclub.web;

import org.photoclub.domain.photo.Photo;
import org.photoclub.domain.session.SessionService;
import org.photoclub.domain.session.dto.SessionDto;
import org.photoclub.domain.session.dto.SingleSessionGalleryDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/sesja/{id}")
    public String singleSession(@PathVariable int id, Model model){
        SingleSessionGalleryDto session = sessionService.getSessionById(id);
        model.addAttribute("session", session);
        model.addAttribute("photos", session.getPhotos());
        model.addAttribute("firstPhoto", session.getPhotos().get(0));
        return "single-session";
    }



}
