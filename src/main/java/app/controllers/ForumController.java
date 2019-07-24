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


import app.entities.Forum;
import app.services.ForumService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/forum")
public class ForumController {
	@Autowired
	ForumService fs;
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Forum>> getForums() {
        return new ResponseEntity<Iterable<Forum>>(fs.getForums(), HttpStatus.OK);
    }
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Forum> addForum(@RequestBody Forum forum) {
		fs.AddForum(forum);
		return new ResponseEntity<Forum>(forum, HttpStatus.OK);
	}
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/{id}")
	public ResponseEntity<Forum> getOne(@PathVariable Long id) {
		Optional<Forum> forum = fs.getForum(id);
		if (forum.isPresent()) {
			return new ResponseEntity<Forum>(forum.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Forum> deleteForum(@PathVariable Long id) {
		try {
			fs.deleteForum(id);
		} catch (Exception e) {
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT);
	}
}