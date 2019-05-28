
package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}