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

import app.entities.ForumReply;
import app.entities.ForumThread;
import app.services.ForumThreadService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/thread")
public class ForumThreadController {
	@Autowired
	ForumThreadService fs;

	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/all")
	public ResponseEntity<Iterable<ForumThread>> getForumThreads() {
		return new ResponseEntity<Iterable<ForumThread>>(fs.getForumThreads(), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<ForumThread> addForumThread(@RequestBody ForumThread forumthread) {
		fs.AddForumThread(forumthread);
		return new ResponseEntity<ForumThread>(forumthread, HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/{id}")
	public ResponseEntity<ForumThread> getForumThread(@PathVariable Long id) {
		Optional<ForumThread> forumthread = fs.getForumThread(id);
		if (forumthread.isPresent()) {
			return new ResponseEntity<ForumThread>(forumthread.get(), HttpStatus.OK);
		}
		return new ResponseEntity<ForumThread>(HttpStatus.NOT_FOUND);
	}
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/{id}/replies")
	public ResponseEntity<Iterable<ForumReply>> getReplies(@PathVariable Long id) {
		return new ResponseEntity<Iterable<ForumReply>>(fs.getReplies(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ForumThread> deleteForumThread(@PathVariable Long id) {
		try {
			fs.deleteForumThread(id);
		} catch (Exception e) {
			return new ResponseEntity<ForumThread>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ForumThread>(HttpStatus.NO_CONTENT);
	}
}
