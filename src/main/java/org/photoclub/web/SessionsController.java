package org.photoclub.web;

import org.photoclub.domain.session.SessionService;
import org.photoclub.domain.session.dto.SessionDto;
import org.photoclub.domain.session.dto.SingleSessionGalleryDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

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
    public String singleSession(@PathVariable Long id, Model model){
        SingleSessionGalleryDto session = sessionService.getSessionById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("sessionTitle", session.getTitle());
        model.addAttribute("photos", session.getPhotos());

        if (session.getPhotos() != null && !session.getPhotos().isEmpty()) {
            model.addAttribute("firstPhoto", session.getPhotos().get(0));
        }
        return "single-session";
    }



}
