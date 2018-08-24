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

import com.student.cucumber.serenity.StudentSerenitySteps;
import com.student.model.StudentClass;
import com.student.testbase.TestBase;
import com.utils.ReusableSpecifications;
import com.utils.TestUtils;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;


import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


/**
 * @author surbhi
 *@author Ranjeet Aug 16, 20188:46:08 PM
 */

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentCRUDTestUsingSpecification extends TestBase{
	
	static String firstName = "SMOKEUSER"+TestUtils.getRandomvalue() ;
	static String lastName = "SMOKEUSER"+TestUtils.getRandomvalue() ;
	static String programme = "ComputerScience";
	static String email = TestUtils.getRandomvalue() +"xyz@gmail.com"; 
	static int studentId;
	
	@Steps
	StudentSerenitySteps step;
	
	@Title("tc001:this will create new Student")
	@Test
	public void tc001() {
		System.out.println("------------ Start testcase: createStudent --------------- ");
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		ValidatableResponse response = step.createStudentUsingSpecification(firstName, lastName, email, programme, courses)
		.statusCode(201)
		.spec(ReusableSpecifications.getGenericResponseSpec())
		;
		
		System.out.println("------------ End testcase: createStudent --------------- ");
	}
	
	
	
	@Title(value = "tc002:Verify if New Student created")
//	@Test
	public void tc002() {
		System.out.println("------------ Start testcase: getStudent --------------- ");
		
		HashMap<String, Object> studentinfo = step.getStudentInfoByFirstName(firstName);
		System.out.println("student map value:"+ studentinfo);
		
		assertThat(studentinfo, hasValue(firstName));
		studentId = (int) studentinfo.get("id");
		
		System.out.println("------------ End testcase: getStudent --------------- ");
	}
	
	
	@Title(value = "tc003:Verify if Student Info updated")
//	@Test
	public void tc003() {
		System.out.println("------------ Start testcase: Student Info updated --------------- ");
		
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		StudentClass student = new StudentClass();
		firstName =firstName +"_updated" ;
		
		step.updateStudentInfoUsingSpecification(studentId, firstName, lastName, email, programme, courses);
		
		System.out.println("------------ fetching updated value of Student Info --------------- ");
		
		HashMap<String, Object> studentinfo = step.getStudentInfoByFirstName(firstName);
		System.out.println("student map value:"+ studentinfo);
		
		assertThat(studentinfo, hasValue(firstName));		//'assertthat' is from junit while 'hasValue' from hamcrest library
		
		System.out.println("------------ End testcase: Student Info updated --------------- ");
	}

	
	@Title(value = "tc004:this will delete Student Info")
//	@Test
	public void tc004() {
		System.out.println("------------ Start testcase: tc004 : Student Info delete --------------- ");
		System.out.println( "--------" + studentId + " =============");
		
		step.deleteStudentByID(studentId);
		step.getStudentInfoByID(studentId).statusCode(404);

		
		System.out.println("------------ End testcase: tc004 : Student Info delete --------------- ");
	}
}




















