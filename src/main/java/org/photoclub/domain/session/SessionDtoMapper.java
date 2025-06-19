package org.photoclub.domain.session;

import org.photoclub.domain.session.Session;
import org.photoclub.domain.session.dto.SessionDto;

class SessionDtoMapper {

    static SessionDto map(Session session){
        return new SessionDto(
                session.getId(),
                session.getTitle(),
                session.getSessionType(),
                session.isPromoted(),
                session.getPhotos().get(0));
    }



}
