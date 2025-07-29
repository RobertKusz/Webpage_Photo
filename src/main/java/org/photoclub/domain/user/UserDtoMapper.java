package org.photoclub.domain.user;

import org.photoclub.domain.user.dto.UserCredentialsDto;
import org.photoclub.domain.user.dto.UserFirstPageDto;

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
        userFirstPageDto.setEmail(user.getEmail());
        userFirstPageDto.setWebpageId(user.getWebpageId());
        return userFirstPageDto;
    }
}
