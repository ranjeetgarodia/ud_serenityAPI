/**
 * 
 */
package com.testSuite.studentInfo;


import java.util.ArrayList;
import java.util.HashMap;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.student.model.StudentClass;
import com.student.testbase.TestBase;
import com.utils.TestUtils;

import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;


import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


/**
 * @author surbhi
 *@author Ranjeet Aug 16, 20188:46:08 PM
 */


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentCRUDTest extends TestBase{
	
	static String firstName = "SMOKEUSER"+TestUtils.getRandomvalue() ;
	static String lastName = "SMOKEUSER"+TestUtils.getRandomvalue() ;
	static String programme = "ComputerScience";
	static String email = TestUtils.getRandomvalue() +"xyz@gmail.com"; 
	static int studentId;
	
	
	@Title("tc001:this will create new Student")
	@Test
	public void tc001() {
		System.out.println("------------ Start testcase: createStudent --------------- ");
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		StudentClass student = new StudentClass();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setCourses(courses);
		
		SerenityRest
		.given()
		.contentType(ContentType.JSON)
		.log().all()
		.when()
		.body(student)
		.post()
		.then()
		.log()
		.all()
//		.headers()
		.statusCode(201)
		;
		
		System.out.println("------------ End testcase: createStudent --------------- ");
	}
	
	
	@Title(value = "tc002:Verify if New Student created")
	@Test
	public void tc002() {
		System.out.println("------------ Start testcase: getStudent --------------- ");
		String s1 ="findAll{it.firstName=='";
		String s2 = "'}.get(0)";
		
		HashMap<String, Object> map = 
		
		SerenityRest.rest()
		.given()
		.when()
		.get("/list")
		.then()
		.log()
		.headers()
//		.all()
		.statusCode(200)
		.extract()
		.path(s1+firstName+s2)		//extract studentinfo with matching firstName
		;
		System.out.println("student map value:"+ map);
		assertThat(map, hasValue(firstName));
		studentId = (int) map.get("id");
		
		System.out.println("------------ End testcase: getStudent --------------- ");
	}
	
	
	@Title(value = "tc003:Verify if Student Info updated")
	@Test
	public void tc003() {
		System.out.println("------------ Start testcase: Student Info updated --------------- ");
		
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		StudentClass student = new StudentClass();
		firstName =firstName +"_updated" ;
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setCourses(courses);
		
		SerenityRest
		.given()
		.contentType(ContentType.JSON)
		.log().all()
		.when()
		.body(student)
		.put("/"+ studentId)	//updating student info for given studentID
		.then()
		.log()
		.all()
//		.headers()
		;
		
		System.out.println("------------ fetching updated value of Student Info --------------- ");
		
		String s1 ="findAll{it.firstName=='";
		String s2 = "'}.get(0)";
		
		HashMap<String, Object> map = SerenityRest
				.given()
				.contentType(ContentType.JSON)
				.log().all()
				.when()
				.get("/list")
				.then()
				.log()
//				.all()
				.headers()
				.extract()
				.path(s1+firstName+s2)		//extract studentinfo with matching firstName
				;
		
		System.out.println("student map value:"+ map);
		assertThat(map, hasValue(firstName));		//'assertthat' is from junit while 'hasValue' from hamcrest library
//		studentId = (int) map.get("id");		
		System.out.println("------------ End testcase: Student Info updated --------------- ");
	}
	
	@Title(value = "tc004:this will delete Student Info")
	@Test
	public void tc004() {
		System.out.println("------------ Start testcase: tc004 : Student Info delete --------------- ");
		System.out.println( "--------" + studentId + " =============");
		SerenityRest.rest()
		.given()
		.when()
		.delete("/" + studentId)	//delete studentinfo for given studentID
		;
		
		SerenityRest.rest()
		.given()
		.when()
		.get("/" + studentId)		//searching for studentInfo for given studentID, but since its deleted, no info should be returned
		.then()
		.log()
		.all()
		.statusCode(404)	// incase of delete expected statuscode is 404
		;
		
		System.out.println("------------ End testcase: tc004 : Student Info delete --------------- ");
	}
}




















