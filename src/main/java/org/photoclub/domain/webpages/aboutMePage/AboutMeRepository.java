package org.photoclub.domain.webpages.aboutMePage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutMeRepository extends CrudRepository<AboutMe,Long> {
}
