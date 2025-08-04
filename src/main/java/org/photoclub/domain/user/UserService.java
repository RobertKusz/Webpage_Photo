package org.photoclub.domain.user;

import org.photoclub.domain.user.dto.UserCredentialsDto;
import org.photoclub.domain.user.dto.UserFirstPageDto;
import org.photoclub.domain.user.dto.UserHomepageDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<UserCredentialsDto> findCredentialsByEmail(String email){
        return userRepository.findByEmail(email)
                .map(user -> UserDtoMapper.map(user));
    }

    public List<UserFirstPageDto> getListOfAllByRole(String role) {
        return userRepository.findByRoles_name(role)
                .stream()
                .map(Optional::orElseThrow)
                .map(UserDtoMapper::mapToFirstPage)
                .collect(Collectors.toList());
    }

    public UserHomepageDto findUserByEmail(String userEmail) {
        UserHomepageDto userHomepageDto = userRepository.findByEmail(userEmail).map(UserDtoMapper::mapToHomepage).orElseThrow();
        return userHomepageDto;
    }

    public UserHomepageDto findUserById(Long id) {
        UserHomepageDto userHomepageDto = userRepository.findById(id).map(UserDtoMapper::mapToHomepage).orElseThrow();
        return userHomepageDto;
    }

    public Long findUserIdByEmail(String userEmail){
        return findUserByEmail(userEmail).getId();
    }
}
