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

import app.entities.ForumUserRole;
import app.services.ForumUserRoleService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/userroles")
public class ForumUserRoleController {
	@Autowired
	ForumUserRoleService fs;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/all")
	public ResponseEntity<Iterable<ForumUserRole>> getForumUserRoles() {
		return new ResponseEntity<Iterable<ForumUserRole>>(fs.getForumUserRoles(), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<ForumUserRole> addForumUserRole(@RequestBody ForumUserRole forumuserrole) {
		fs.AddForumUserRole(forumuserrole);
		return new ResponseEntity<ForumUserRole>(forumuserrole, HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/{id}")
	public ResponseEntity<ForumUserRole> getForumUserRole(@PathVariable Long id) {
		Optional<ForumUserRole> forumuserrole = fs.getForumUserRole(id);
		if (forumuserrole.isPresent()) {
			return new ResponseEntity<ForumUserRole>(forumuserrole.get(), HttpStatus.OK);
		}
		return new ResponseEntity<ForumUserRole>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ForumUserRole> deleteForumUserRole(@PathVariable Long id) {
		try {
			fs.deleteForumUserRole(id);
		} catch (Exception e) {
			return new ResponseEntity<ForumUserRole>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ForumUserRole>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
}