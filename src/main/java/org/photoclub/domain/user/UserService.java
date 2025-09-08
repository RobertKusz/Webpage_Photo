package org.photoclub.domain.user;

import org.photoclub.domain.user.dto.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
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

    public UserHomepageDto findUserHomepageDtoById(Long id) {
        UserHomepageDto userHomepageDto = userRepository.findById(id).map(UserDtoMapper::mapToHomepage).orElseThrow();
        return userHomepageDto;
    }
    public Long findUserIdByEmail(String userEmail){
        return findUserByEmail(userEmail).getId();
    }

    public void registerUserWithDefaultRole(UserRegistrationDto userRegistrationDto){
        UserRole defaultRole = userRoleRepository.findByName("USER").orElseThrow();
        User user = new User();
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        user.getRoles().add(defaultRole);
        userRepository.save(user);
    }
    public void registerUserWithPhotographRole(PhotographRegistrationDto photographRegistrationDto){
        UserRole photographRole = userRoleRepository.findByName("PHOTOGRAPH").orElseThrow();
        User user = new User();
        user.setEmail(photographRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(photographRegistrationDto.getPassword()));
        user.getRoles().add(photographRole);
        user.setPhotographingType(photographRegistrationDto.getPhotographingType());
        userRepository.save(user);
    }
}
