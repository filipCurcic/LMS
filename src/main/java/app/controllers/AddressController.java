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

import app.entities.Address;
import app.services.AddressService;
import app.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<Iterable<Address>> getAll(){
		return new ResponseEntity<Iterable<Address>>(addressService.getAddress(), HttpStatus.OK);
	}
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Optional<Address> address = addressService.getOne(id);
        if(address.isPresent()) {
            return new ResponseEntity<Address>(address.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
    }

	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Address> addAddress(@RequestBody Address address){
		addressService.addAddress(address);
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Address> deleteAddress(@PathVariable Long id){
		try {
			addressService.removeAddress(id);
		} catch (Exception e) {
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Address> editAddress(@PathVariable Long id, @RequestBody Address address){
		addressService.updateAddress(id, address);
		return new ResponseEntity<Address>(address, HttpStatus.CREATED);
	}

}
