package org.photoclub.domain.session.dto;

import org.photoclub.domain.photo.Photo;

import java.util.List;

public class SingleSessionGalleryDto {
    private Long id;
    private String title;
    private List<Photo> photos;
    private Photo mainPhoto;

    public SingleSessionGalleryDto(Long id, String title, List<Photo> photo, Photo mainPhoto) {
        this.id = id;
        this.title = title;
        this.photos = photo;
        this.mainPhoto = mainPhoto;
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

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public Photo getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(Photo mainPhoto) {
        this.mainPhoto = mainPhoto;
    }
}
