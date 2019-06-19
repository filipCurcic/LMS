package app.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.entities.ForumRole;
import app.repositories.ForumRoleRepository;

@Service
public class ForumRoleService {
	@Autowired
	ForumRoleRepository fr;

	public ForumRoleService() {
	}

	public Iterable<ForumRole> getForumRoles() {
		return fr.findAll();
	}

	public Optional<ForumRole> getForumRole(Long id) {
		return fr.findById(id);
	}

	public void AddForumRole(ForumRole forumrole) {
		fr.save(forumrole);
	}

	public void deleteForumRole(Long id) {
		Optional<ForumRole> forumrole = fr.findById(id);
		fr.delete(forumrole.get());
	}
}