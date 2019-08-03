package app.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.entities.ForumReply;
import app.entities.ForumSubForum;

@Repository
public interface ForumSubForumRepository extends CrudRepository<ForumSubForum, Long> {
	
	@Query("SELECT sf FROM ForumSubForum sf WHERE sf.subFacultyForum.id = ?1")
	ArrayList<ForumSubForum> getSubForums(Long id);
}