package it.try2solve.oauth.parser;

import static junit.framework.Assert.*;
import it.try2solve.data.model.User;
import it.try2solve.data.model.UserSource;
import it.try2solve.oauth.parser.FacebookParser;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class FacebookParserTest {

	@BeforeClass
	public static void setUpOnce() {
	}

	@AfterClass
	public static void tearDownOnce() {
	}

	@Test
	public void testUserParse() {
		/*
		String xmlData = "{\"id\":\"524428840\",\"name\":\"Artur Mkrtchyan\",\"first_name\":\"Artur\",\"last_name\":\"Mkrtchyan\"," +
				"\"link\":\"http:\\/\\/www.facebook.com\\/artur.mkrtchyan\",\"username\":\"artur.mkrtchyan\",\"hometown\":" +
				"{\"id\":\"\",\"name\":null},\"location\":{\"id\":\"111152442240366\",\"name\":\"Yerevan, Armenia\"}," +
				"\"gender\":\"male\",\"timezone\":-8,\"locale\":\"en_GB\",\"verified\":true,\"updated_time\":\"2011-10-31T17:57:13+0000\"}";
		
		FacebookParser parser = new FacebookParser();
		
		User user = parser.getUser(xmlData);
		System.out.println(user);
		assertEquals("524428840", user.getSocialId());
		assertEquals("Artur", user.getFirstName());
		assertEquals("Mkrtchyan", user.getLastName());
		assertEquals(UserSource.FaceBook, user.getUserSourceAsEnum());
		*/
	}
}
