package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.ForumSubForum;
import app.repositories.ForumSubForumRepository;

@Service
public class ForumSubForumService {
	@Autowired
	ForumSubForumRepository fr;

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
}