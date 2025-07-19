package org.photoclub.web.admin;

import org.photoclub.domain.session.SessionService;
import org.photoclub.domain.session.dto.SessionDto;
import org.photoclub.domain.session.dto.SessionSaveDto;
import org.photoclub.domain.session.dto.SingleSessionGalleryDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SessionManagementController {
    private final SessionService sessionService;

    public SessionManagementController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/admin/dodaj_sesje")
    public String getAddingSessionPanel(Model model){
        SessionSaveDto sessionSaveDto = new SessionSaveDto();
        model.addAttribute("session", sessionSaveDto);
        return "admin/add-session";
    }

    @PostMapping("/admin/dodaj_sesje")
    public String addSession(SessionSaveDto sessionSaveDto, RedirectAttributes redirectAttributes){
        sessionService.addSession(sessionSaveDto);
        redirectAttributes.addFlashAttribute(AdminController.NOTIFICATION_ATTRIBUTE,
                "Film %s został zapisany".formatted(sessionSaveDto.getTitle()));
        return "redirect:/admin";
    }

    @GetMapping("/admin/edytuj_sesje")
    public String getEditingSessionPanel(Model model){
        List<SessionDto> allSessions = sessionService.getAllSessions();
        model.addAttribute("sessions", allSessions);
        return "admin/edit-session";
    }

    @PostMapping("/admin/edytuj-sesje/delete/{id}")
    public String deleteSession(@PathVariable Long id) {
        sessionService.deleteById(id);
        return "redirect:/admin/edytuj_sesje";
    }

    @GetMapping("/admin/edytuj_sesje/{id}")
    public String editSession(@PathVariable Long id, Model model) {
        SingleSessionGalleryDto session = sessionService.getSessionById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("sess", session);
        return "admin/edit-session-details";
    }
    @PostMapping("/admin/edytuj_sesje/{sessionId}/main-photo")
    public String setMainPhoto(@PathVariable Long sessionId, @RequestParam Long photoId) {
        sessionService.setMainPhoto(sessionId, photoId);
        return "redirect:/admin/edytuj_sesje/" + sessionId;
    }

    @PostMapping("/admin/edytuj_sesje/{sessionId}/delete-photo")
    public String deletePhoto(@PathVariable Long sessionId, @RequestParam Long photoId) {
        sessionService.deletePhoto(photoId);
        return "redirect:/admin/edytuj_sesje/" + sessionId;
    }

//jeśli usune zdjęcie które jest zdjeciem głownym strona wybucha


}
