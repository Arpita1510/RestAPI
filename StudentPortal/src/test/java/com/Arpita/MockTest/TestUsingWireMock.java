/*package com.Arpita.MockTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.anyUrl;
import static com.github.tomakehurst.wiremock.client.WireMock.exactly;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.RequestBuilder;

import com.Arpita.Service.StudentMapper;
import com.Arpita.Service.StudentService;
import com.Arpita.BusinessObject.Student;
import com.Arpita.DataAccessObject.StudentDAO;
import com.Arpita.EntityObject.StudentEO;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.common.Json;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = { "server.baseuri=http://localhost:8080" })
public class TestUsingWireMock {
	
	@Autowired
	private StudentService studentService;
	
	@MockBean
	private StudentDAO studentDAO;
	
	private List<StudentEO> studentList = new ArrayList<StudentEO>();
	
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(WireMockConfiguration.options().port(8080).httpsPort(9999)
	.notifier(new ConsoleNotifier(true)).extensions(new ResponseTemplateTransformer(true)));
	
	@BeforeEach
	void setUp() {
		StudentEO student1 = new StudentEO(1,"Arpita" , 11, "Kolkata" , 8 , "C");
		StudentEO student2 = new StudentEO(2,"Riya" , 13, "Delhi" , 8 , "B");
		StudentEO student3 = new StudentEO(3,"Arpita" , 16, "Kolkata" , 10 , "A");
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
	}
	
	@Test
	public void  getStudentDetails() throws Exception {
		
	    wireMockRule.stubFor(get(urlPathEqualTo("/viewStudent/")).willReturn(aResponse().withStatus(200)
	        .withHeader("Content-Type", "application/json").withBody(Json.write(studentList))));
	    
	    Mockito.when(studentDAO.findAll()).thenReturn(studentList);
	    
	    List<Student> resultFromService = studentService.viewStudent();

	    assertEquals(3,resultFromService.size());
	}

}
*/