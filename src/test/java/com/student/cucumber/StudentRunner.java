/**
 * 
 */
package com.student.cucumber;

import org.junit.runner.RunWith;

import com.student.testbase.TestBase;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

/**
 * @author surbhi
 *@author Ranjeet Aug 24, 20186:04:29 PM
 */


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/feature"
//		,glue= {"stepDefinitions"}
		,plugin = { "pretty", "html:target/cucumber-reports" }
		,monochrome = true
		)
public class StudentRunner extends TestBase{
	
	
}

































