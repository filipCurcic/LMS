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

import app.entities.ForumFile;
import app.services.ForumFileService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/forumfile")
public class ForumFileController {
	@Autowired
	ForumFileService fs;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<ForumFile>> getForumFiles() {
		return new ResponseEntity<Iterable<ForumFile>>(fs.getForumFiles(), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<ForumFile> addForumFile(@RequestBody ForumFile forumfile) {
		fs.AddForumFile(forumfile);
		return new ResponseEntity<ForumFile>(forumfile, HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/{id}")
	public ResponseEntity<ForumFile> getForumFile(@PathVariable Long id) {
		Optional<ForumFile> forumfile = fs.getForumFile(id);
		if (forumfile.isPresent()) {
			return new ResponseEntity<ForumFile>(forumfile.get(), HttpStatus.OK);
		}
		return new ResponseEntity<ForumFile>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ForumFile> deleteForumFile(@PathVariable Long id) {
		try {
			fs.deleteForumFile(id);
		} catch (Exception e) {
			return new ResponseEntity<ForumFile>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ForumFile>(HttpStatus.NO_CONTENT);
	}
}
