package org.photoclub.domain.session;

import org.photoclub.domain.session.dto.SessionDto;
import org.photoclub.domain.session.dto.SingleSessionGalleryDto;

public class SessionDtoMapper {

    public static SessionDto map(Session session){
        return new SessionDto(
                session.getId(),
                session.getTitle(),
                session.getSessionType(),
                session.isPromoted(),
                session.getMainPhoto());
    }

    static SingleSessionGalleryDto mapToSingleSessionGallery(Session session){
        return new SingleSessionGalleryDto(
                session.getId(),
                session.getTitle(),
                session.getPhotos(),
                session.getMainPhoto()
        );
    }

}
