package com.Arpita.ControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Arpita.BusinessObject.Student;
import com.Arpita.Controller.StudentController;
import com.Arpita.Service.StudentService;

@WebMvcTest(value = StudentController.class)
public class StudentControllerTest {
	
	  
	  @Autowired 
	  private MockMvc mockmvc;
	  
	  @MockBean //using a mock bean of studentService not the originalstudentService. 
	  private StudentService studentService;
	  
	  Student mockStudent = new Student(1, "Arpita" , 11, "Kolkata" , 8 , "C");
	  String exampleStudentJson =
	  "{\"name\":\"Arpita\",\"age\":\"11\",\"address\" : \"Kolkata\", \"standard\" : \"8\", \"section\" : \"C\"}"
	  ;
	  
	  
	  //For GET request
	  @Test 
	  public void getStudentDetailsFromId() throws Exception {
	  
	  String expectedResult =
	  "{id:1,name:Arpita,age:11,address:Kolkata,standard:8,section:C}";
	  
	  Mockito.when(studentService.viewStudentById(Mockito.anyInt())).thenReturn(mockStudent);
	  
	  RequestBuilder request =
	  MockMvcRequestBuilders.get("/viewStudent/1/").accept(MediaType.APPLICATION_JSON); 
	  MvcResult result = mockmvc.perform(request).andReturn();
	  
	  System.out.println("**************" + result.getResponse().getContentAsString() + "******************");
	  
	  JSONAssert.assertEquals(expectedResult ,
	  result.getResponse().getContentAsString(),false); }
	  
	  
	  //For POST request
	  @Test 
	  public void addNewStudent() throws Exception {
	  
	  Student mockStudent = new Student(1, "Arpita" , 11, "Kolkata" , 8 , "C");
	  
	  Mockito.when(studentService.addStudent(Mockito.any(Student.class))).
	  thenReturn(mockStudent);
	  
	  RequestBuilder request =
	  MockMvcRequestBuilders.post("/addStudent/").accept(MediaType.APPLICATION_JSON
	  ).content(exampleStudentJson).contentType(MediaType.APPLICATION_JSON);
	  MvcResult result = mockmvc.perform(request).andReturn();
	  MockHttpServletResponse response = result.getResponse();
	  
	  assertEquals(HttpStatus.CREATED.value(), response.getStatus()); 
	  }
	 }
	 