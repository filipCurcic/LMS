
package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Forum;
import app.repositories.ForumRepository;

@Service
public class ForumService {
	@Autowired
	ForumRepository fr;

	public ForumService() {
    }

    public Iterable<Forum> getForums() {
        return fr.findAll();
    }

	public Optional<Forum> getForum(Long id) {
		return fr.findById(id);
	}

	public void AddForum(Forum forum) {
		fr.save(forum);
	}

	public void deleteForum(Long id) {
		Optional<Forum> forum = fr.findById(id);
		fr.delete(forum.get());
	}
}
