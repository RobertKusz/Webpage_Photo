package org.photoclub.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<Optional<User>> findByRoles_name(String role);
    List<Optional<User>> findByPhotographingType(PhotoType photoType);
    List<User> findAll();
}
