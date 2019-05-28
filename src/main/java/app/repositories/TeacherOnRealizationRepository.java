
package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.TeacherOnRealization;

@Repository
public interface TeacherOnRealizationRepository extends JpaRepository<TeacherOnRealization, Long> {
}