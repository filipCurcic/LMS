package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.ForumUser;
import app.entities.Student;
import app.repositories.ForumUserRepository;

@Service
public class ForumUserService {
	@Autowired
	ForumUserRepository fr;

	public ForumUserService() {
	}

	public Iterable<ForumUser> getForumUsers() {
		return fr.findAll();
	}

	public Optional<ForumUser> getForumUser(Long id) {
		return fr.findById(id);
	}

	public void AddForumUser(ForumUser forumuser) {
		fr.save(forumuser);
	}

	public void deleteForumUser(Long id) {
		Optional<ForumUser> forumuser = fr.findById(id);
		fr.delete(forumuser.get());
	}
	
	public Optional<ForumUser> getLoggedUser(String username) {
        return fr.getLoggedUser(username);
    }
}