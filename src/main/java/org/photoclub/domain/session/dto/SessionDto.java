package org.photoclub.domain.session.dto;

import org.photoclub.domain.photo.Photo;

public class SessionDto {
    private Long id;
    private String title;
    private String sessionType;
    private boolean promoted;
    private Photo mainPhoto;

    public SessionDto(Long id, String title, String sessionType, boolean promoted, Photo photo) {
        this.id = id;
        this.title = title;
        this.sessionType = sessionType;
        this.promoted = promoted;
        this.mainPhoto = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public Photo getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(Photo mainPhoto) {
        this.mainPhoto = mainPhoto;
    }
}

