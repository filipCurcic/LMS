package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Address;
import app.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRep;
	
	public Iterable<Address> getAddress() {
		return addressRep.findAll();
	}
	
	public Optional<Address> getOne(Long id) {
		return addressRep.findById(id);
	}
	
	public void addAddress(Address address) {
		addressRep.save(address);
	}
	
	public void removeAddress(Long id) {
		Optional<Address> addre= addressRep.findById(id);
		if(addre.isPresent()) {
			addressRep.delete(addre.get());
		}
	}
	
	public void updateAddress(Long id, Address address) {
		Optional<Address> addre = addressRep.findById(id);
		if(addre.isPresent()) {
			address.setId(addre.get().getId());
			addressRep.save(address);
		}
	}

}
