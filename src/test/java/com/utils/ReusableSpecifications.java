/**
 * 
 */
package com.utils;

import io.restassured.builder.RequestSpecBuilder;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

/**
 * @author surbhi
 *@author Ranjeet Aug 21, 20187:34:32 PM
 */
public class ReusableSpecifications {

	public static RequestSpecBuilder rspec;
	public static RequestSpecification requestspecification;
	
	public static ResponseSpecBuilder respec;
	public static ResponseSpecification responsespecification;
	
	
	public static RequestSpecification getGenericRequestSpec() {
		
		rspec = new RequestSpecBuilder();
		rspec.setContentType(ContentType.JSON);
		
		requestspecification = rspec.build();
		
		return requestspecification;
	}
	
	
	public static ResponseSpecification getGenericResponseSpec() {
		
		respec = new ResponseSpecBuilder();
		respec.expectContentType(ContentType.JSON);
		respec.expectHeader("Content-type", "application/json;charset=UTF-8");
		respec.expectHeader("Transfer-Encoding", "chunked");
		respec.expectResponseTime(lessThan(5L), TimeUnit.SECONDS);
		
		responsespecification = respec.build();
		
		return responsespecification;
		
	}
	
}
