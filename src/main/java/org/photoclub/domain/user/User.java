package org.photoclub.domain.user;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String faceBook;
    private String instagram;
    private String logoHomeFilename;
    private String miniatureFilename;
    private Long homePageId;
    private Long aboutMePageId;
    private Long contactPageId;
    private Long portfolioPageId;
    private String portfolioDescription;
    private String photographingType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<UserRole> roles = new HashSet<>();

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getFaceBook() {
        return faceBook;
    }

    public void setFaceBook(String faceBook) {
        this.faceBook = faceBook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getLogoHomeFilename() {
        return logoHomeFilename;
    }

    public void setLogoHomeFilename(String logoHomeFilename) {
        this.logoHomeFilename = logoHomeFilename;
    }

    public String getMiniatureFilename() {
        return miniatureFilename;
    }

    public void setMiniatureFilename(String miniatureFilename) {
        this.miniatureFilename = miniatureFilename;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public Long getHomePageId() {
        return homePageId;
    }

    public void setHomePageId(Long homePageId) {
        this.homePageId = homePageId;
    }

    public Long getAboutMePageId() {
        return aboutMePageId;
    }

    public void setAboutMePageId(Long aboutMePageId) {
        this.aboutMePageId = aboutMePageId;
    }

    public String getPortfolioDescription() {
        return portfolioDescription;
    }

    public void setPortfolioDescription(String portfolioDescription) {
        this.portfolioDescription = portfolioDescription;
    }
    public String getPhotographingType() {
        return photographingType;
    }

    public void setPhotographingType(String photographingType) {
        this.photographingType = photographingType;
    }

    public Long getContactPageId() {
        return contactPageId;
    }

    public void setContactPageId(Long contactPageId) {
        this.contactPageId = contactPageId;
    }

    public Long getPortfolioPageId() {
        return portfolioPageId;
    }

    public void setPortfolioPageId(Long portfolioPageId) {
        this.portfolioPageId = portfolioPageId;
    }
}
