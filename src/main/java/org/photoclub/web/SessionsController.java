package org.photoclub.web;

import org.photoclub.domain.session.SessionService;
import org.photoclub.domain.session.dto.SessionDto;
import org.photoclub.domain.session.dto.SingleSessionGalleryDto;
import org.photoclub.domain.user.User;
import org.photoclub.domain.user.UserRepository;
import org.photoclub.domain.user.UserService;
import org.photoclub.domain.user.dto.UserHomepageDto;
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
    private final UserService userService;

    public SessionsController(SessionService sessionService, UserRepository userRepository, UserService userService) {
        this.sessionService = sessionService;
        this.userService = userService;
    }

    @GetMapping("{id}/sesje")
    public String sessionPage(@PathVariable Long id, Model model){
        UserHomepageDto user = userService.findUserById(id);
        List<SessionDto> allSessions = sessionService.getAllSessionsByWebpageId(user.getWebpageId());

//        List<SessionDto> allSessions = sessionService.getAllSessions();
        model.addAttribute("allSessions", allSessions);
        return "sessions";
    }

    @GetMapping("/sesja/{id}")
    public String singleSession(@PathVariable Long id, Model model){
        SingleSessionGalleryDto session = sessionService.getSessionById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        model.addAttribute("sessionTitle", session.getTitle());
        model.addAttribute("photos", session.getPhotos());
        model.addAttribute("firstPhoto", session.getMainPhoto());
        return "single-session";
    }



}
