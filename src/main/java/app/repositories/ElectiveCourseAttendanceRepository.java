package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.ElectiveCourseAttendance;

@Repository
public interface ElectiveCourseAttendanceRepository extends JpaRepository<ElectiveCourseAttendance, Long> {

}
