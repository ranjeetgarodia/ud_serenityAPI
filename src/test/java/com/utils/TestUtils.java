/**
 * 
 */
package com.utils;

import java.util.Random;

import org.junit.Test;

/**
 * @author surbhi
 *@author Ranjeet Aug 16, 20189:19:21 PM
 */
public class TestUtils {

//	@Test
	public static String getRandomvalue() {
		Random random = new Random();
				
		int randomInt = random.nextInt(100000);
		
		return Integer.toString(randomInt);
		
	}
}
