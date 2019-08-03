package app.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.entities.ForumReply;
import app.entities.ForumSubFacultyForum;

public interface ForumFacultySubForumRepository extends CrudRepository<ForumSubFacultyForum, Long> {
	@Query("SELECT fr FROM ForumReply fr WHERE fr.forumThread.id = ?1")
	ArrayList<ForumReply> getThreadReplies(Long id);
}
