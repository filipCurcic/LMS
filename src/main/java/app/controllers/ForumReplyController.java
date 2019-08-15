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
import app.services.ForumReplyService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/reply")
public class ForumReplyController {
	@Autowired
	ForumReplyService fs;

	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/all")
	public ResponseEntity<Iterable<ForumReply>> getForumReplys() {
		return new ResponseEntity<Iterable<ForumReply>>(fs.getForumReplies(), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<ForumReply> addForumReply(@RequestBody ForumReply forumreply) {
		System.out.println(forumreply.getClass());

		fs.AddForumReply(forumreply);
		return new ResponseEntity<ForumReply>(forumreply, HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/{id}")
	public ResponseEntity<ForumReply> getForumReply(@PathVariable Long id) {
		Optional<ForumReply> forumreply = fs.getForumReply(id);
		if (forumreply.isPresent()) {
			return new ResponseEntity<ForumReply>(forumreply.get(), HttpStatus.OK);
		}
		return new ResponseEntity<ForumReply>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ForumReply> deleteForumReply(@PathVariable Long id) {
		try {
			fs.deleteForumReply(id);
		} catch (Exception e) {
			return new ResponseEntity<ForumReply>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ForumReply>(HttpStatus.NO_CONTENT);
	}
}
