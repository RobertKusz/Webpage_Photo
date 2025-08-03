package org.photoclub.domain.session;

import org.photoclub.domain.photo.Photo;
import org.photoclub.domain.photo.PhotoRepository;
import org.photoclub.domain.session.dto.SessionDto;
import org.photoclub.domain.session.dto.SessionSaveDto;
import org.photoclub.domain.session.dto.SingleSessionGalleryDto;
import org.photoclub.storage.FileStorageService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;
    private final FileStorageService fileStorageService;
    private final PhotoRepository photoRepository;

    public SessionService(SessionRepository sessionRepository, FileStorageService fileStorageService, PhotoRepository photoRepository) {
        this.sessionRepository = sessionRepository;
        this.fileStorageService = fileStorageService;
        this.photoRepository = photoRepository;
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


    @Transactional
    public void changeMainPhoto(Long sessionId, Long photoId) {
        Session session = sessionRepository.findById(sessionId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Photo photo = photoRepository.findById(photoId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        session.setMainPhoto(photo);
        sessionRepository.save(session);
    }

    @Transactional
    public void deletePhoto(Long sessionId, Long photoId) {
        Session session = sessionRepository.findById(sessionId).orElseThrow();
        if (photoId.equals(session.getMainPhoto().getId())) {
            if (session.getPhotos().size() == 1){
                deleteById(session.getId());
            }else {
                photoRepository.deleteById(photoId);
                session.setMainPhoto(session.getPhotos().get(0));
                sessionRepository.save(session);
            }
        }
    }

    public List<SessionDto> getAllSessionsByWebpageId(Long webpageId) {
        return sessionRepository.findByWebpageId(webpageId)
                .stream()
                .map(Optional::orElseThrow)
                .map(SessionDtoMapper::map)
                .toList();
    }
}
