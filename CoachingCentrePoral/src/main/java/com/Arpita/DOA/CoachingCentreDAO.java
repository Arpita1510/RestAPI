package com.Arpita.DOA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Arpita.BO.CoachingCentre;

public interface CoachingCentreDAO extends JpaRepository<CoachingCentre, Integer> {

	CoachingCentre findById(int id);

}
