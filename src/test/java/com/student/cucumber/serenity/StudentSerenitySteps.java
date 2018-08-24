/**
 * 
 */
package com.student.cucumber.serenity;

import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.student.model.StudentClass;
import com.utils.ReusableSpecifications;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

/**
 * @author surbhi
 *@author Ranjeet Aug 20, 20187:58:12 PM
 */
public class StudentSerenitySteps {

	@Step
	public ValidatableResponse createStudent(String firstName,String lastName,String email,String programme,
			ArrayList<String> courses) {
		
		StudentClass student = new StudentClass();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setCourses(courses);
		
		ValidatableResponse response = SerenityRest
		.given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		;
		
		return response;
	}
	
	
	
	@Step
	public ValidatableResponse createStudentUsingSpecification(String firstName,String lastName,String email,String programme,
			ArrayList<String> courses) {
		
		StudentClass student = new StudentClass();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setCourses(courses);
		
		ValidatableResponse response = SerenityRest
		.given()
		.spec(ReusableSpecifications.getGenericRequestSpec())
		.log()
		.all()
		.when()
		.body(student)
		.post()
		.then()
		.log()
		.all()
		;
		
		return response;
	}
	
	
	
	@Step("Getting student info with firstName:{0}")
	public HashMap<String, Object> getStudentInfoByFirstName(String firstName){
		System.out.println("---- getStudentInfoByFirstName ---- ");
		String s1 ="findAll{it.firstName=='";
		String s2 = "'}.get(0)";
		
		HashMap<String, Object> map = 
		 SerenityRest.rest()
		.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200)
		.extract()
		.path(s1+firstName+s2)		//extract studentinfo with matching firstName
		;
		return map;
	}
	
	@Step("Updating Student info for given studentID")
	public ValidatableResponse updateStudentInfo(int studentID,String firstName, String lastName, String email,
			String programme,List<String> courses) {
		StudentClass student = new StudentClass();
//		firstName =firstName +"_updated" ;
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setCourses(courses);
		
		ValidatableResponse response = SerenityRest
		.given()
		.contentType(ContentType.JSON)
		.log().all()
		.when()
		.body(student)
		.put("/"+ studentID)	//updating student info for given studentID
		.then()
		;
		return response ;
	}
	
	
	
	@Step("Updating Student info for given studentID")
	public ValidatableResponse updateStudentInfoUsingSpecification(int studentID,String firstName, String lastName, String email,
			String programme,List<String> courses) {
		StudentClass student = new StudentClass();
//		firstName =firstName +"_updated" ;
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setCourses(courses);
		
		ValidatableResponse response = SerenityRest
		.given()
		.spec(ReusableSpecifications.getGenericRequestSpec())
		.log().all()
		.when()
		.body(student)
		.put("/"+ studentID)	//updating student info for given studentID
		.then()
		;
		return response ;
	}
	
	@Step
	public void deleteStudentByID(int studentID) {
		SerenityRest.rest()
		.given()
		.when()
		.delete("/" + studentID)	//delete studentinfo for given studentID
		;
	}
	
	
	
	@Step("Getting student info with firstName:{0}")
	public ValidatableResponse getStudentInfoByID(int studentID){
		System.out.println("---- getStudentInfoByFirstName ---- ");
		
		ValidatableResponse response = 
		 SerenityRest.rest()
		.given()
		.when()
		.get("/"+studentID)
		.then()
		;
		return response;
	}
	
	
	
}





















