package app.controllers;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.entities.AdministratorStaff;
import app.services.AdministratorStaffService;
import app.services.FileService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/administrator-staff")
public class AdministratorStaffController {
	
	@Autowired
	AdministratorStaffService adminStaffService;
	
	@Autowired
    FileService fileService;
    
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/all")
	public ResponseEntity<Iterable<AdministratorStaff>> getAll(){
		return new ResponseEntity<Iterable<AdministratorStaff>>(adminStaffService.getAdministratorStaff(), HttpStatus.OK);
	}
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping("/{id}")
	public ResponseEntity<AdministratorStaff> getAdministratorStaff(@PathVariable Long id) {
		Optional<AdministratorStaff> adminStaff = adminStaffService.getOne(id);
		if (adminStaff.isPresent()) {
			return new ResponseEntity<AdministratorStaff>(adminStaff.get(), HttpStatus.OK);
		}
		return new ResponseEntity<AdministratorStaff>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Secured("ROLE_ADMINISTRATOR")
	public ResponseEntity<AdministratorStaff> addAdministrator(@RequestPart("profileImage") MultipartFile file, @RequestPart("data") String administratorStaffString) throws IOException {
		AdministratorStaff administratorStaff= new ObjectMapper().readValue(administratorStaffString, AdministratorStaff.class);
		fileService.addProfileImageAdministratorStaff(file, "administrative_staff_" + administratorStaff.getRegisteredUser().getUsername(), administratorStaff);
		adminStaffService.addAdministratorStaff(administratorStaff);;
		return new ResponseEntity<AdministratorStaff>(administratorStaff, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<AdministratorStaff> deleteAdministrator(@PathVariable Long id){
		try {
			adminStaffService.removeAdministratorStaff(id);
		} catch (Exception e) {
			return new ResponseEntity<AdministratorStaff>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AdministratorStaff>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<AdministratorStaff> editAdministrator(@PathVariable Long id, @RequestBody AdministratorStaff administratorStaff){
		adminStaffService.updateAdministrationStaff(id, administratorStaff);
		return new ResponseEntity<AdministratorStaff>(administratorStaff, HttpStatus.OK);
	}


}
