package app.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.RegisteredUser;

@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {

	Optional<RegisteredUser> findByUsername (String username);
}
