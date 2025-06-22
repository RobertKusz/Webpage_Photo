package org.photoclub.domain.session;

import org.photoclub.domain.session.dto.SessionDto;
import org.photoclub.domain.session.dto.SingleSessionGalleryDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<SessionDto> findAllPromotedSessionsByType(String type){
        return sessionRepository.findAllByPromotedIsTrueAndSessionType(type)
                .stream()
                .map(SessionDtoMapper::map)
                .toList();
    }

    public List<SessionDto> getAllSessions() {
        return sessionRepository.findAll().stream().map(SessionDtoMapper::map).collect(Collectors.toList());
    }

    public SingleSessionGalleryDto getSessionById(int id) {
        return SessionDtoMapper.mapToSingleSessionGallery(sessionRepository.findById(id));
    }
}
