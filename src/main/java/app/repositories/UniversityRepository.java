
package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
}
