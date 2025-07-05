package org.photoclub.web.admin;

import org.photoclub.domain.session.SessionService;
import org.photoclub.domain.session.dto.SessionSaveDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
}
