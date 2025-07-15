package org.photoclub.domain.session;

import org.photoclub.domain.photo.Photo;
import org.photoclub.domain.session.dto.SessionDto;
import org.photoclub.domain.session.dto.SessionSaveDto;
import org.photoclub.domain.session.dto.SingleSessionGalleryDto;
import org.photoclub.storage.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;
    private final FileStorageService fileStorageService;

    public SessionService(SessionRepository sessionRepository, FileStorageService fileStorageService) {
        this.sessionRepository = sessionRepository;
        this.fileStorageService = fileStorageService;
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

    public Optional <SingleSessionGalleryDto> getSessionById(Long id) {
        return sessionRepository.findById(id).map(SessionDtoMapper::mapToSingleSessionGallery);
    }

    public void addSession(SessionSaveDto sessionToSave) {
        Session session = new Session();
        session.setTitle(sessionToSave.getTitle());
        session.setSessionType(sessionToSave.getSessionType());
        session.setPromoted(sessionToSave.isPromoted());
        session.setCreatedAt(sessionToSave.getCreatedAt());

        List<Photo> photoList = new ArrayList<>();

        if (sessionToSave.getPhotos() != null) {
            for (MultipartFile photoFile : sessionToSave.getPhotos()) {
                if (photoFile != null && !photoFile.isEmpty()) {
                    String savedFilename = fileStorageService.saveImage(photoFile);

                    Photo photo = new Photo();
                    photo.setSession(session);
                    photo.setFilename(savedFilename);

                    photoList.add(photo);
                }
            }
        }

        session.setPhotos(photoList);
        sessionRepository.save(session);
    }

    public void deleteById(Long id){
        sessionRepository.deleteById(id);
    }

}
