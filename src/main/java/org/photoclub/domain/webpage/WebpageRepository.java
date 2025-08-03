package org.photoclub.domain.webpage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebpageRepository extends CrudRepository<Webpage, Long> {

}
