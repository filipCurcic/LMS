package app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

	Optional<Permission> findByTitle (String title);
}
