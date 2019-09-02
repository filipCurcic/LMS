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

import app.entities.ForumSubForum;
import app.services.ForumSubForumService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/subforum")
public class SubForumController {
	
	@Autowired
	ForumSubForumService ss;

	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/all")
	public ResponseEntity<Iterable<ForumSubForum>> getSubForums() {
		return new ResponseEntity<Iterable<ForumSubForum>>(ss.getForumSubForums(), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<ForumSubForum> addSubForum(@RequestBody ForumSubForum subforum) {
		ss.AddForumSubForum(subforum);
		return new ResponseEntity<ForumSubForum>(subforum, HttpStatus.OK);
	}

	@RequestMapping("/{id}")
	public ResponseEntity<ForumSubForum> getSubForum(@PathVariable Long id) {
		Optional<ForumSubForum> subforum = ss.getForumSubForum(id);
		if (subforum.isPresent()) {
			return new ResponseEntity<ForumSubForum>(subforum.get(), HttpStatus.OK);
		}
		return new ResponseEntity<ForumSubForum>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ForumSubForum> deleteSubForum(@PathVariable Long id) {
		try {
			ss.deleteForumSubForum(id);
		} catch (Exception e) {
			return new ResponseEntity<ForumSubForum>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ForumSubForum>(HttpStatus.NO_CONTENT);
	}
}