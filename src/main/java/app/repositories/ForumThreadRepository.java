package app.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.entities.ForumThread;

public interface ForumThreadRepository extends CrudRepository<ForumThread, Long>{
	
	@Query("SELECT ft FROM ForumThread ft WHERE ft.subForum.id = ?1")
	ArrayList<ForumThread> getThreadsFromSubForum(Long id);
}
