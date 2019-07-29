package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.entities.ForumSubForum;

@Repository
public interface ForumSubForumRepository extends CrudRepository<ForumSubForum, Long> {
}