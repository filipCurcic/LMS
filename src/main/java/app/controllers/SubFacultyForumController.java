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

import app.entities.ForumSubFacultyForum;
import app.entities.ForumSubForum;
import app.services.ForumFacultySubForumService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/facultyforum")
public class SubFacultyForumController {
	
	@Autowired
	ForumFacultySubForumService ss;

	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/all")
	public ResponseEntity<Iterable<ForumSubFacultyForum>> getSubFacultyForums() {
		return new ResponseEntity<Iterable<ForumSubFacultyForum>>(ss.getForumFacultySubForums(), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<ForumSubFacultyForum> addSubFacultyForum(@RequestBody ForumSubFacultyForum subfacultyforum) {
		ss.AddForumFacultySubForum(subfacultyforum);
		return new ResponseEntity<ForumSubFacultyForum>(subfacultyforum, HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/{id}")
	public ResponseEntity<ForumSubFacultyForum> getSubFacultyForum(@PathVariable Long id) {
		Optional<ForumSubFacultyForum> subfacultyforum = ss.getForumFacultySubForum(id);
		if (subfacultyforum.isPresent()) {
			return new ResponseEntity<ForumSubFacultyForum>(subfacultyforum.get(), HttpStatus.OK);
		}
		return new ResponseEntity<ForumSubFacultyForum>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ForumSubFacultyForum> deleteSubFacultyForum(@PathVariable Long id) {
		try {
			ss.deleteForumFacultySubForum(id);
		} catch (Exception e) {
			return new ResponseEntity<ForumSubFacultyForum>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ForumSubFacultyForum>(HttpStatus.NO_CONTENT);
	}
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/{id}/subForums")
	public ResponseEntity<Iterable<ForumSubForum>> getSubForums(@PathVariable Long id) {
		return new ResponseEntity<Iterable<ForumSubForum>>(ss.getSubForums(id), HttpStatus.OK);
	}
	
	
	
}