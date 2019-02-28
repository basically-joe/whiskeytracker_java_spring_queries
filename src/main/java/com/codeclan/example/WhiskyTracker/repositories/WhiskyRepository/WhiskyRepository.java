package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long>, WhiskyRepositoryCustom {

	List<Whisky> getWhiskyByYear(int year);
	List<Whisky> findWhiskyBYDistilleryId(Long id);

	// Spring Data JPA Method ("Derived") Query (no body needed)
	List<Whisky> findWhiskyByDistilleryIdAndAge(Long distilleryId, int age);
}
