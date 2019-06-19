package app.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.entities.ForumSubFacultyForum;
import app.repositories.ForumFacultySubForumRepository;

@Service
public class ForumFacultySubForumService {
	@Autowired
	ForumFacultySubForumRepository fr;

	public ForumFacultySubForumService() {
	}

	public Iterable<ForumSubFacultyForum> getForumFacultySubForums() {
		return fr.findAll();
	}

	public Optional<ForumSubFacultyForum> getForumFacultySubForum(Long id) {
		return fr.findById(id);
	}

	public void AddForumFacultySubForum(ForumSubFacultyForum forumfacultysubforum) {
		fr.save(forumfacultysubforum);
	}

	public void deleteForumFacultySubForum(Long id) {
		Optional<ForumSubFacultyForum> forumfacultysubforum = fr.findById(id);
		fr.delete(forumfacultysubforum.get());
	}
}
