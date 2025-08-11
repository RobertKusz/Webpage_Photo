package org.photoclub.domain.user.dto;

public class UserFirstPageDto {
    private Long id;
    private String email;
    private Long webpageId;
    private String firstName;
    private String lastName;
    private String miniatureFilename;
    private String photographingType;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiniatureFilename() {
        return miniatureFilename;
    }

    public void setMiniatureFilename(String miniatureFilename) {
        this.miniatureFilename = miniatureFilename;
    }

    public String getPhotographingType() {
        return photographingType;
    }

    public void setPhotographingType(String photographingType) {
        this.photographingType = photographingType;
    }
}
