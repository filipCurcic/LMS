package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.entities.Forum;

@Repository
public interface ForumRepository extends CrudRepository<Forum, Long> {
}
