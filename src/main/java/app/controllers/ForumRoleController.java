package app.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;
import app.entities.ForumRole;
import app.services.ForumRoleService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/forumrole")
public class ForumRoleController {
	@Autowired
	ForumRoleService fs;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<ForumRole>> getForumRoles() {
		return new ResponseEntity<Iterable<ForumRole>>(fs.getForumRoles(), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<ForumRole> addForumRole(@RequestBody ForumRole forumrole) {
		fs.AddForumRole(forumrole);
		return new ResponseEntity<ForumRole>(forumrole, HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/{id}")
	public ResponseEntity<ForumRole> getForumRole(@PathVariable Long id) {
		Optional<ForumRole> forumrole = fs.getForumRole(id);
		if (forumrole.isPresent()) {
			return new ResponseEntity<ForumRole>(forumrole.get(), HttpStatus.OK);
		}
		return new ResponseEntity<ForumRole>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ForumRole> deleteForumRole(@PathVariable Long id) {
		try {
			fs.deleteForumRole(id);
		} catch (Exception e) {
			return new ResponseEntity<ForumRole>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ForumRole>(HttpStatus.NO_CONTENT);
	}
}