/**
 * 
 */
package com.testSuite.studentInfo;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.student.cucumber.serenity.StudentSerenitySteps;
import com.student.testbase.TestBase;
import com.utils.TestUtils;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;

/**
 * @author surbhi
 *@author Ranjeet Aug 21, 20188:06:53 PM
 */

//@Concurrent(threads="2x")	// 2-thread per cpu core
@UseTestDataFrom("testdata/studentinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentDataDrivenTest extends TestBase {

	private String firstName;
	private String lastName ;
	private String email ;
	private String programme ;
	private String course;
	 
	static int studentId;
	
	@Steps
	StudentSerenitySteps steps;
	
	@Title(value = "DataDriven Test to Add Student")
	@Test
	public void tc001() {
		ArrayList<String> courses = new ArrayList<String>();
		courses.add(course);
		
		steps.createStudentUsingSpecification(firstName, lastName, email, programme, courses)
		.statusCode(201)
		;
	}

	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public static int getStudentId() {
		return studentId;
	}

	public static void setStudentId(int studentId) {
		CreateStudentDataDrivenTest.studentId = studentId;
	}

	public StudentSerenitySteps getSteps() {
		return steps;
	}

	public void setSteps(StudentSerenitySteps steps) {
		this.steps = steps;
	}
	
	
	
	
}

























