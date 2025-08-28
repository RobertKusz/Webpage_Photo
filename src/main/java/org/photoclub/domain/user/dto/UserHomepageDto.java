package org.photoclub.domain.user.dto;

public class  UserHomepageDto {
    private Long id;
    private String email;
    private Long webpageId;
    private String facebook;
    private String instagram;
    private String logoFilename;

    public String getLogoFilename() {
        return logoFilename;
    }

    public void setLogoFilename(String logoFilename) {
        this.logoFilename = logoFilename;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getWebpageId() {
        return webpageId;
    }

    public void setWebpageId(Long webpageId) {
        this.webpageId = webpageId;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String faceBook) {
        this.facebook = faceBook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}
