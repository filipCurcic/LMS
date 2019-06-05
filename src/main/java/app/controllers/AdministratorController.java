package app.controllers;

import java.util.List;
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

import app.dto.AdministratorDto;
import app.entities.Administrator;
import app.mappers.AdministratorMapper;
import app.services.AdministatorService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/administrator")
public class AdministratorController {
	
	@Autowired
	AdministatorService adminService;
	
	@Autowired
	AdministratorMapper administratorMapper;
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<AdministratorDto>> getAll(){
		List<Administrator> administrator = adminService.getAdministrator();
		return ResponseEntity.ok(administratorMapper.toDTO(administrator));
	}
	
	@RequestMapping("/{id}")
	public AdministratorDto getAdministrator(@PathVariable Long id) {
		Administrator administrator = adminService.getOne(id);
		return administratorMapper.toDTO(administrator);
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Administrator> addAddress(@RequestBody Administrator administrator){
		adminService.addAdministrator(administrator);
		return new ResponseEntity<Administrator>(administrator, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Administrator> deleteAdministrator(@PathVariable Long id){
		try {
			adminService.removeAdministrator(id);
		} catch (Exception e) {
			return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Administrator>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Administrator> editAdministrator(@PathVariable Long id, @RequestBody Administrator administrator){
		adminService.updateAdministrator(id, administrator);
		return new ResponseEntity<Administrator>(administrator, HttpStatus.OK);
	}


	
}
