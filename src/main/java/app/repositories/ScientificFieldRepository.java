
package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.ScientificField;

@Repository
public interface ScientificFieldRepository extends JpaRepository<ScientificField, Long> {
}