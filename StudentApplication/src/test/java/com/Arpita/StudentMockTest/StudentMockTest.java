package com.Arpita.StudentMockTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.Arpita.StudentBO.Course;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.Json;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest
public class StudentMockTest {
	
	private static WireMockServer server = new WireMockServer(9001);
	
	RestTemplate restTemplate = new RestTemplate();	
    ResponseEntity response;
	
	@BeforeEach
	public void setUp(){
		WireMock.configureFor("localhost", 9001);
		server.start();
	}
	
	@Test
	public void studentCourseTest() throws Exception {
		
		Course course = new Course(1, "Maths", 5, 1000 , "Sunil");
		String expectedResult = "{id:1,name:Maths,standard:5,fees:1000,teacherName:Sunil}";;
				
		WireMock.stubFor(WireMock.get("/viewCourse/1").willReturn(aResponse().withStatus(200)
		        .withHeader("Content-Type", "application/json").withBody(Json.write(course))));
		
		response = restTemplate.getForEntity("http://localhost:9001/viewCourse/1", String.class);
		
		JSONAssert.assertEquals(expectedResult , response.getBody().toString(),false);
	}
	
	@Test
	public void studentCourseMsgTest() throws Exception {
		
		String expectedResult = "Welcome";
		
		WireMock.stubFor(WireMock.get("/course/").willReturn(aResponse().withStatus(200)
		        .withHeader("Content-Type",MediaType.TEXT_PLAIN_VALUE).withBody("Welcome")));
		
		response = restTemplate.getForEntity("http://localhost:9001/course/", String.class);
		 
		assertEquals(expectedResult , response.getBody().toString());
	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@AfterEach
	public void closeUp() {
		if(server != null && server.isRunning()) {
			server.stop();
		}
	}
	
}
