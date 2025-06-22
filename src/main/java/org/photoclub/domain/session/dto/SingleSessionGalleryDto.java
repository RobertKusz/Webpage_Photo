package org.photoclub.domain.session.dto;

import org.photoclub.domain.photo.Photo;

import java.util.List;

public class SingleSessionGalleryDto {
    private Long id;
    private String title;
    private List<Photo> photos;

    public SingleSessionGalleryDto(Long id, String title, List<Photo> photo) {
        this.id = id;
        this.title = title;
        this.photos = photo;
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
}
