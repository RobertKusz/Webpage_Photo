package org.photoclub.domain.session;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SessionRepository extends CrudRepository<Session,Long> {
    List<Session> findAllByPromotedIsTrueAndSessionType(String sessionType);
    List<Session> findAll();

    Session findById(int id);
}
