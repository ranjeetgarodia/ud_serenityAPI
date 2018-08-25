/**
 * 
 */
package com.student.cucumber.steps;

//import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.student.cucumber.serenity.StudentSerenitySteps;
import com.utils.TestUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

/**
 * @author surbhi
 *@author Ranjeet Aug 24, 20185:56:48 PM
 */


public class CucumberStudentSteps {
	static String email=null;
	
	@Steps
	StudentSerenitySteps steps;
	
	@When("^user send GET request to list Student, they should get response statusCode 200$")
	public void verify_statuscode_200_for_list_endpoint() {
		SerenityRest.rest()
		.given()
		.when()
		.get("/list")
		.then()
//		.time(lessThan(40L),TimeUnit.MILLISECONDS)
		.log()
		.headers()
		.statusCode(200)
		;
	}
	
	@When("^user send GET request to list Student, they should get response statusCode 201$")
	public void verify_statuscode_201_for_list_endpoint() {
		SerenityRest.rest()
		.given()
		.when()
		.get("/list")
		.then()
		.statusCode(200)
		;
	}

//	//I create student by providing firstname <firstname> lastName <lastName> email <email> 
//	@When("^I create student by providing firstname (.*) lastName (.*) email (.*) programme (.*) course (.*)$")
//	public void create_newStudent_validate(String firstName,String lastName,String _email,String program, String course) {
//		System.out.println("I create student by providing firstname <firstname> lastName <lastName> email <email> ");
//		
//		ArrayList<String> courses = new ArrayList<String>();
//		courses.add(course);
//		email =TestUtils.getRandomvalue()+_email;
//		
//		step.createStudentUsingSpecification(firstName, lastName, email, program, courses)
//		.assertThat()
//		.statusCode(201)
//		;
//	}
//
//	@Then("^I verify that student with email (.*) has been created$")
//	public void verifyStudent(String email) {
//		HashMap<String, Object> actualvalue = step.getStudentInfoByEmailId(email);
//		
//		assertThat(actualvalue, hasValue(email));
//	}



	
	
	@When("^simple_Outline testcase fname (.*)$")
	public void simple_Outline(String firstName) {
		System.out.println("simple outline testcases");
	}
	
	
	@When("^I create a new student by providing the information firstName (.*) lastName (.*) email (.*) programme (.*) courses (.*)$")
	public void createStudent(String firstName,String lastName,String _email,String programme,String course){
		List<String> courses = new ArrayList<>();
		courses.add(course);
		 email =TestUtils.getRandomvalue()+ _email;
		
		 steps.createStudent(firstName, lastName, email, programme, courses)
		 .assertThat()
		 .statusCode(201);
		
	}
	
	@Then("^I verify that the student with (.*) is created$")
	public void verifyStudent(String emailId){
		HashMap<String, Object> actualValue=	steps.getStudentInfoByEmailId(email);
		assertThat(actualValue, hasValue(email));
	}
}
























