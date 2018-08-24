/**
 * 
 */
package com.testSuite.test;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author surbhi
 *@author Ranjeet Aug 14, 20188:52:12 PM
 */



@RunWith(SerenityRunner.class)
public class FirstSerenity {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost:8080/student";
//		RestAssured.basePath = "/list";
	}
	
	@Title(value = "this is first serenity testcase")
	@Test
	public void tc001() {
		System.out.println(" ---------- testcase: tc001 ---------------");
		System.out.println( " header of the response :: for 'get' method ====");
		SerenityRest
		.given()
		.when()
		.get("/list")
		.then()
		.log()
		.headers()
		.statusCode(200)
		;
		System.out.println(" ---------- End testcase tc001 ---------------");
	}
	
	
	@Test
	public void thisisfailing() {
		System.out.println(" ---------- testcase: thisisfailing ---------------");
		System.out.println( " header of the response :: for 'get' method ====");
		SerenityRest
		.given()
		.when()
		.get("/list")
		.then()
		.log()
		.headers()
		.statusCode(201)
		;
		System.out.println(" ---------- End testcase: thisisfailing ---------------");
	}
	
	@Pending
	@Test
	public void thisisPendingTest() {
		System.out.println(" ---------- testcase: thisisPendingTest ---------------");
		System.out.println( " header of the response :: for 'get' method ====");
		SerenityRest
		.given()
		.when()
		.get("/list")
		.then()
		.log()
		.headers()
		.statusCode(201)
		;
		System.out.println(" ---------- End testcase: thisisPendingTest ---------------");
	}
	
	

	@Ignore
	@Test
	public void thisisSkippedTest() {
		System.out.println(" ---------- testcase: thisisSkippedTest ---------------");
		
		
		System.out.println(" ---------- End testcase: thisisSkippedTest ---------------");
	}
	
	
	
	@Test
	public void thisisaTestwithError() {
		System.out.println(" ---------- testcase: thisisaTestwithError ---------------");
		System.out.println(5/0);
		
		System.out.println(" ---------- End testcase: thisisaTestwithError ---------------");
	}
	
	
	@Test
	public void filenotExist() throws FileNotFoundException {
		System.out.println(" ---------- testcase: filenotExist ---------------");
		File file = new File("E:\\file.text");
		FileReader freader=new FileReader(file);
		
		System.out.println(" ---------- End testcase: filenotExist ---------------");
	}
	
	@Manual
	@Test
	public void manualTest() throws FileNotFoundException {
		System.out.println(" ---------- testcase: manualTest ---------------");
		
		
		System.out.println(" ---------- End testcase: manualTest ---------------");
	}
	
}































