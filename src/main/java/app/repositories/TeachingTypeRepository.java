
package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.TeachingType;

@Repository
public interface TeachingTypeRepository extends JpaRepository<TeachingType, Long> {
}