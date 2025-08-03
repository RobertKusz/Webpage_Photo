package org.photoclub.domain.session;

import jakarta.persistence.*;
import org.photoclub.domain.photo.Photo;
import org.photoclub.domain.webpage.Webpage;
//import org.photoclub.domain.webpage.Webpage;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sessionType;
    private String title;
    private LocalDateTime createdAt;
    private boolean promoted;
    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos;
    @OneToOne
    @JoinColumn(name = "main_photo")
    private Photo mainPhoto;
    @ManyToOne
    @JoinColumn(name = "webpage_id")
    private Webpage webpage;

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }


    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    public Webpage getWebpage() {
        return webpage;
    }

    public void setWebpage(Webpage webpage) {
        this.webpage = webpage;
    }
}
