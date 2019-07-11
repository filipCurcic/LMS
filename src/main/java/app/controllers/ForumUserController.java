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
import app.entities.ForumUser;
import app.services.ForumUserService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/forumuser")
public class ForumUserController {
	@Autowired
	ForumUserService fs;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<ForumUser>> getForumUsers() {
		return new ResponseEntity<Iterable<ForumUser>>(fs.getForumUsers(), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<ForumUser> addForumUser(@RequestBody ForumUser forumuser) {
		fs.AddForumUser(forumuser);
		return new ResponseEntity<ForumUser>(forumuser, HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/{id}")
	public ResponseEntity<ForumUser> getForumUser(@PathVariable Long id) {
		Optional<ForumUser> forumuser = fs.getForumUser(id);
		if (forumuser.isPresent()) {
			return new ResponseEntity<ForumUser>(forumuser.get(), HttpStatus.OK);
		}
		return new ResponseEntity<ForumUser>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ForumUser> deleteForumUser(@PathVariable Long id) {
		try {
			fs.deleteForumUser(id);
		} catch (Exception e) {
			return new ResponseEntity<ForumUser>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ForumUser>(HttpStatus.NO_CONTENT);
	}
}