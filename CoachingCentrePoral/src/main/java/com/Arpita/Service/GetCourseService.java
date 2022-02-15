package com.Arpita.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COURSE-PORTAL")//*value = "COURSE-PORTAL" , url = "http://localhost:9001/" */
public interface GetCourseService {
	
	@GetMapping("/course/viewCourse/")
	public Object getCourseDtl();

}
