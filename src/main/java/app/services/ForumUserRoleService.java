package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.ForumUserRole;
import app.repositories.ForumUserRoleRepository;

@Service
public class ForumUserRoleService {
	@Autowired
	ForumUserRoleRepository fr;

	public ForumUserRoleService() {
	}

	public Iterable<ForumUserRole> getForumUserRoles() {
		return fr.findAll();
	}

	public Optional<ForumUserRole> getForumUserRole(Long id) {
		return fr.findById(id);
	}

	public void AddForumUserRole(ForumUserRole forumuserrole) {
		fr.save(forumuserrole);
	}

	public void deleteForumUserRole(Long id) {
		Optional<ForumUserRole> forumuserrole = fr.findById(id);
		fr.delete(forumuserrole.get());
	}
}