package org.photoclub.domain.webpages.homePage;

import jakarta.persistence.*;
import org.photoclub.domain.session.Session;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Webpage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstBackground;
    private String introductionFirstLayer;
    private String introductionSecondLayer;
    private String photographerPhoto;
    private String descriptionFirstLayer;
    private String descriptionSecondLayer;
    private String descriptionThirdLayer;
    private String rollingPhoto;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "webpage_id")
    private List<Session> sessions = new ArrayList<>();


    public String getIntroductionFirstLayer() {
        return introductionFirstLayer;
    }

    public void setIntroductionFirstLayer(String introductionFirstLayer) {
        this.introductionFirstLayer = introductionFirstLayer;
    }

    public String getIntroductionSecondLayer() {
        return introductionSecondLayer;
    }

    public void setIntroductionSecondLayer(String introductionSecondLayer) {
        this.introductionSecondLayer = introductionSecondLayer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstBackground() {
        return firstBackground;
    }

    public void setFirstBackground(String firstBackground) {
        this.firstBackground = firstBackground;
    }

    public String getPhotographerPhoto() {
        return photographerPhoto;
    }

    public void setPhotographerPhoto(String photographerPhoto) {
        this.photographerPhoto = photographerPhoto;
    }

    public String getDescriptionFirstLayer() {
        return descriptionFirstLayer;
    }

    public void setDescriptionFirstLayer(String descriptionFirstLayer) {
        this.descriptionFirstLayer = descriptionFirstLayer;
    }

    public String getDescriptionSecondLayer() {
        return descriptionSecondLayer;
    }

    public void setDescriptionSecondLayer(String descriptionSecondLayer) {
        this.descriptionSecondLayer = descriptionSecondLayer;
    }

    public String getDescriptionThirdLayer() {
        return descriptionThirdLayer;
    }

    public void setDescriptionThirdLayer(String descriptionThirdLayer) {
        this.descriptionThirdLayer = descriptionThirdLayer;
    }

    public String getRollingPhoto() {
        return rollingPhoto;
    }

    public void setRollingPhoto(String rollingPhoto) {
        this.rollingPhoto = rollingPhoto;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
}