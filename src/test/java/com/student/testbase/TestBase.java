/**
 * 
 */
package com.student.testbase;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

/**
 * @author surbhi
 *@author Ranjeet Aug 16, 20188:49:30 PM
 */
public class TestBase {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost:8080/student";
	}
}
