package org.photoclub.domain.user;

import org.photoclub.domain.user.dto.UserCredentialsDto;
import org.photoclub.domain.user.dto.UserFirstPageDto;
import org.photoclub.domain.user.dto.UserHomepageDto;

import java.util.Set;
import java.util.stream.Collectors;

public class UserDtoMapper {
    static UserCredentialsDto map(User user){
        String email = user.getEmail();
        String password = user.getPassword();
        Set<String> roles = user.getRoles()
                .stream()
                .map(UserRole::getName)
                .collect(Collectors.toSet());
        return new UserCredentialsDto(email, password, roles);
    }

    public static UserFirstPageDto mapToFirstPage(User user){
        UserFirstPageDto userFirstPageDto = new UserFirstPageDto();
        userFirstPageDto.setId(user.getId());
        userFirstPageDto.setEmail(user.getEmail());
        userFirstPageDto.setWebpageId(user.getHomePageId());
        userFirstPageDto.setFirstName(user.getFirstName());
        userFirstPageDto.setLastName(user.getLastName());
        userFirstPageDto.setMiniatureFilename(user.getMiniatureFilename());
        userFirstPageDto.setPhotographingType(user.getPhotographingType());
        return userFirstPageDto;
    }

    public static UserHomepageDto mapToHomepage(User user){
        UserHomepageDto userHomepageDto = new UserHomepageDto();
        userHomepageDto.setId(user.getId());
        userHomepageDto.setEmail(user.getEmail());
        userHomepageDto.setWebpageId(user.getHomePageId());
        userHomepageDto.setFacebook(user.getFaceBook());
        userHomepageDto.setInstagram(user.getInstagram());
        userHomepageDto.setLogoFilename(user.getLogoHomeFilename());
        return userHomepageDto;
    }
}
