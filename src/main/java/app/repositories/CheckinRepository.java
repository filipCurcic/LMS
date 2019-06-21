package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Checkin;

public interface CheckinRepository extends JpaRepository<Checkin, Long> {

}
