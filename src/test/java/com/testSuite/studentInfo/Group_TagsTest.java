/**
 * 
 */
package com.testSuite.studentInfo;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.student.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;


/**
 * @author surbhi
 *@author Ranjeet Aug 22, 20185:34:43 PM
 */


@RunWith(SerenityRunner.class)
public class Group_TagsTest extends TestBase{

	
	@WithTags({ 
		@WithTag("studentfeature:smoke"),
		@WithTag("studentfeature:NEGATIVE")
	}
	)
	@Title(value = "provide a 405 status code")
	@Test
	public void inValidMethod() {
		SerenityRest
		.given()
		.when()
		.post("/list")
		.then()
		.statusCode(405)
		.log()
		.all()
		;
	}
	
	@WithTags({ 
			@WithTag("studentfeature:smoke"),
			@WithTag("studentfeature:positive")
		}
		)
	@Title(value = "provide a 200 statuc code")
	@Test
	public void verifythestatuscodeIS200() {
		SerenityRest
		.given()
		.when()
		.get("/list")
		.then()
		.statusCode(200)
		.log()
		.headers()
//		.all()
		;
	}
	
	@WithTag("studentfeature:NEGATIVE")
	@Title(value = "provide a 400 status code")
	@Test
	public void incorrectResource() {
		SerenityRest
		.given()
		.when()
		.get("/listabc")
		.then()
		.statusCode(400)
		.log()
		.all()
		;
	}
}






















