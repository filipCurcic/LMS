
package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.StudentOnYear;

@Repository
public interface StudentOnYearRepository extends JpaRepository<StudentOnYear, Long> {
}