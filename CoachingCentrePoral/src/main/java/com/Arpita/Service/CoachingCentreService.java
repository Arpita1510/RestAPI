package com.Arpita.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Arpita.BO.CoachingCentre;
import com.Arpita.DOA.CoachingCentreDAO;

@Service
public class CoachingCentreService {
	
	@Autowired
	private CoachingCentreDAO coachingCentreDAO;

	public CoachingCentre addCentre(CoachingCentre centre) {
		return coachingCentreDAO.save(centre);
	}

	public List<CoachingCentre> viewCentre() {
		return coachingCentreDAO.findAll();
	}

	public CoachingCentre getCentreById(int id) {
		return coachingCentreDAO.findById(id);
	}

}
