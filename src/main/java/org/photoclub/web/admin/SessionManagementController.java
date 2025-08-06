package org.photoclub.web.admin;

import org.photoclub.domain.photo.PhotoService;
import org.photoclub.domain.session.SessionService;
import org.photoclub.domain.session.dto.SessionDto;
import org.photoclub.domain.session.dto.SessionSaveDto;
import org.photoclub.domain.session.dto.SingleSessionGalleryDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SessionManagementController {
    private final SessionService sessionService;
    private final PhotoService photoService;

    public SessionManagementController(SessionService sessionService, PhotoService photoService) {
        this.sessionService = sessionService;
        this.photoService = photoService;
    }

    @GetMapping("/admin/{userId}/dodaj_sesje")
    public String getAddingSessionPanel(Model model, @PathVariable Long userId){
        SessionSaveDto sessionSaveDto = new SessionSaveDto();
        model.addAttribute("session", sessionSaveDto);
        model.addAttribute("userId",userId);
        return "admin/add-session";
    }

    @PostMapping("/admin/{userId}/dodaj_sesje")
    public String addSession(SessionSaveDto sessionSaveDto, RedirectAttributes redirectAttributes, @PathVariable Long userId){
        sessionService.addSession(sessionSaveDto, userId);
        redirectAttributes.addFlashAttribute(AdminController.NOTIFICATION_ATTRIBUTE,
                "Film %s został zapisany".formatted(sessionSaveDto.getTitle()));
        return "redirect:/admin";
    }

    @GetMapping("/admin/{userId}/edytuj_sesje")
    public String getEditingSessionPanel(Model model, @PathVariable Long userId){
        List<SessionDto> allSessions = sessionService.getAllSessionsByUserId(userId);
        model.addAttribute("sessions", allSessions);
        return "admin/edit-session";
    }

    @PostMapping("/admin/{userId}/edytuj-sesje/delete/{id}")
    public String deleteSession(@PathVariable Long id, @PathVariable Long userId) {
        sessionService.deleteById(id);
        return "redirect:/admin/"+userId+"/edytuj_sesje";
    }

    @GetMapping("/admin/{userId}/edytuj_sesje/{id}")
    public String editSession(@PathVariable Long id, Model model, @PathVariable Long userId) {
        SingleSessionGalleryDto session = sessionService.getSessionById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("sess", session);
        model.addAttribute("userId", userId);
        return "admin/edit-session-details";
    }
    @PostMapping("/admin/{userId}/edytuj_sesje/{sessionId}/main-photo")
    public String changeMainPhoto(@PathVariable Long sessionId, @RequestParam Long photoId, @PathVariable Long userId) {
        sessionService.changeMainPhoto(sessionId, photoId);
        return "redirect:/admin/"+userId+"/edytuj_sesje/" + sessionId;
    }

    @PostMapping("/admin/{userId}/edytuj_sesje/{sessionId}/delete-photo")
    @ResponseBody
    public ResponseEntity<?> deletePhoto(@PathVariable Long sessionId, @RequestParam Long photoId, @PathVariable Long userId) {
        sessionService.deletePhoto(sessionId, photoId);
        return ResponseEntity.ok().build();
    }

}

