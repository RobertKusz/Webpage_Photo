package org.photoclub.domain.user.dto;

public class UserFirstPageDto {
    private String email;
    private Long webpageId;

    public UserFirstPageDto() {
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
}
