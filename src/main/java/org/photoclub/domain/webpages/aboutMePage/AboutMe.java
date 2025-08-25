package org.photoclub.domain.webpages.aboutMePage;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class AboutMe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "about_me_short_description", joinColumns = @JoinColumn(name = "about_me_id"))
    @Column(name = "short_description")
    private List<String> shortDescription;

    @ElementCollection
    @CollectionTable(name = "about_me_long_description", joinColumns = @JoinColumn(name = "about_me_id"))
    @Column(name = "long_description")
    private List<String> longDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(List<String> shortDescription) {
        this.shortDescription = shortDescription;
    }

    public List<String> getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(List<String> longDescription) {
        this.longDescription = longDescription;
    }
}
