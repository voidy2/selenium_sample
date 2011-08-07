package test.java;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Test1 extends BaseSelenium {

	@Test
	public void test1() throws Exception {
		driver.get("http://www.grails.org/plugin/geb");
		try {
			assertEquals("http://www.grails.org/plugin/geb", driver.getCurrentUrl());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

}
