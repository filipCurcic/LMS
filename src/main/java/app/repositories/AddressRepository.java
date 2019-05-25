package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}