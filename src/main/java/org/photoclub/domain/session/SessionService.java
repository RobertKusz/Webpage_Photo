package org.photoclub.domain.session;

import org.photoclub.domain.session.dto.SessionDto;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
