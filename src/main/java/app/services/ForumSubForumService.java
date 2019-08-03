package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.ForumSubForum;
import app.entities.ForumThread;
import app.repositories.ForumSubForumRepository;
import app.repositories.ForumThreadRepository;

@Service
public class ForumSubForumService {
	@Autowired
	ForumSubForumRepository fr;
	
	@Autowired
	ForumThreadRepository tr;

	public ForumSubForumService() {
	}

	public Iterable<ForumSubForum> getForumSubForums() {
		return fr.findAll();
	}

	public Optional<ForumSubForum> getForumSubForum(Long id) {
		return fr.findById(id);
	}

	public void AddForumSubForum(ForumSubForum forumsubforum) {
		fr.save(forumsubforum);
	}

	public void deleteForumSubForum(Long id) {
		Optional<ForumSubForum> forumsubforum = fr.findById(id);
		fr.delete(forumsubforum.get());
	}
	
	public Iterable<ForumThread> getAllThreads(Long id) {
		return tr.getThreadsFromSubForum(id);
	}
	
	
}