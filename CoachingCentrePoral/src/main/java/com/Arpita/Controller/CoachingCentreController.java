package com.Arpita.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Arpita.BO.CoachingCentre;
import com.Arpita.Service.CoachingCentreService;
import com.Arpita.Service.GetCourseService;

@RestController
@RequestMapping("/centre")
public class CoachingCentreController implements GetCourseService{
	
	@Autowired
	private CoachingCentreService coachingCentreService;
	
	@Autowired
	private GetCourseService getCourseService;
	
	@PostMapping("/addCentre/")
	public String addCentre(@RequestBody CoachingCentre centre) {
		
		CoachingCentre addedCentre = coachingCentreService.addCentre(centre);
		
		if(addedCentre != null) {
			return "centre added";
		}else {
			return "centre not added";
		}
	}
	
	@GetMapping("/viewCentre")
	public List<CoachingCentre> getCentre(){
		return coachingCentreService.viewCentre();
	}
	
	@GetMapping("/viewCentre/{id}")
	public CoachingCentre getCentreById(@PathVariable int id) {
		return coachingCentreService.getCentreById(id);
	}

	@Override
	@GetMapping("/viewCourse/")
	public Object getCourseDtl() {
		return getCourseService.getCourseDtl();
	}
	

}
