package it.try2solve.oauth.parser;

import static junit.framework.Assert.*;
import it.try2solve.data.model.User;
import it.try2solve.data.model.UserSource;
import it.try2solve.oauth.parser.LinkedInParser;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class LinkedInParserTest {

	@BeforeClass
	public static void setUpOnce() {
	}

	@AfterClass
	public static void tearDownOnce() {
	}

	@Test
	public void testUserParse() {
		/*
		String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
		        + "<person>"
		        + "<id>OjiuGIIlya</id>"
		        + "<first-name>Artur</first-name>"
		        + "<last-name>Mkrtchyan</last-name>"
		        + "<industry>Computer Software</industry>"
		        + "<headline>Software Engineer at AtTask, Inc.</headline>"
		        + "</person>";
		
		LinkedInParser parser = new LinkedInParser();
		
		User user = parser.getUser(xmlData);
		System.out.println(user);
		assertEquals("OjiuGIIlya", user.getSocialId());
		assertEquals("Artur", user.getFirstName());
		assertEquals("Mkrtchyan", user.getLastName());
		assertEquals("Software Engineer at AtTask, Inc.", user.getTitle());
		assertEquals(UserSource.LinkedIn, user.getUserSourceAsEnum());
		*/
	}
}
