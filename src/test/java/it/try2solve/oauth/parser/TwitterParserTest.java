package it.try2solve.oauth.parser;

import static junit.framework.Assert.*;
import it.try2solve.data.model.User;
import it.try2solve.oauth.parser.TwitterParser;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class TwitterParserTest {

	@BeforeClass
	public static void setUpOnce() {
	}

	@AfterClass
	public static void tearDownOnce() {
	}

	@Test
	public void testUserParse() {
		/*
		String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
		        + "<user>"
		        + "<id>122119770</id>"
		        + "<name>Artur</name>"
		        + "<screen_name>mkrtchyanartur</screen_name>"
		        + "<location></location>"
		        + "<description></description>"
		        + "<profile_image_url>http://a2.twimg.com/sticky/default_profile_images/default_profile_3_normal.png</profile_image_url>"
		        + "<profile_image_url_https>https://si0.twimg.com/sticky/default_profile_images/default_profile_3_normal.png</profile_image_url_https>"
		        + "<url></url>"
		        + "<protected>false</protected>"
		        + "<followers_count>1</followers_count>"
		        + "<profile_background_color>C0DEED</profile_background_color>"
		        + "<profile_text_color>333333</profile_text_color>"
		        + "<profile_link_color>0084B4</profile_link_color>"
		        + "<profile_sidebar_fill_color>DDEEF6</profile_sidebar_fill_color>"
		        + "<profile_sidebar_border_color>C0DEED</profile_sidebar_border_color>"
		        + "<friends_count>0</friends_count>"
		        + "<created_at>Thu Mar 11 17:13:39 +0000 2010</created_at>"
		        + "<favourites_count>0</favourites_count>"
		        + "<utc_offset></utc_offset>"
		        + "<time_zone></time_zone>"
		        + "<profile_background_image_url>http://a0.twimg.com/images/themes/theme1/bg.png</profile_background_image_url>"
		        + "<profile_background_image_url_https>https://si0.twimg.com/images/themes/theme1/bg.png</profile_background_image_url_https>"
		        + "<profile_background_tile>false</profile_background_tile>"
		        + "<profile_use_background_image>true</profile_use_background_image>"
		        + "<notifications>false</notifications>"
		        + "<geo_enabled>false</geo_enabled>"
		        + "<verified>false</verified>"
		        + "<following>false</following>"
		        + "<statuses_count>11</statuses_count>"
		        + "<lang>en</lang>"
		        + "<contributors_enabled>false</contributors_enabled>"
		        + "<follow_request_sent>false</follow_request_sent>"
		        + "<listed_count>0</listed_count>"
		        + "<show_all_inline_media>false</show_all_inline_media>"
		        + "<default_profile>true</default_profile>"
		        + "<default_profile_image>true</default_profile_image>"
		        + "<is_translator>false</is_translator>"
		        + "<status>"
		        + "<created_at>Thu May 06 20:26:19 +0000 2010</created_at>"
		        + "<id>13506361247</id>"
		        + "<text>Test | http://prelive.mov.io/dI</text>"
		        + "<source>&lt;a href=&quot;http://prelive.mov.io&quot; rel=&quot;nofollow&quot;&gt;Movio_Prelive&lt;/a&gt;</source>"
		        + "<truncated>false</truncated>"
		        + "<favorited>false</favorited>"
		        + "<in_reply_to_status_id></in_reply_to_status_id>"
		        + "<in_reply_to_user_id></in_reply_to_user_id>"
		        + "<in_reply_to_screen_name></in_reply_to_screen_name>"
		        + "<retweet_count>0</retweet_count>"
		        + "<retweeted>false</retweeted>" + "<geo/>" + "<coordinates/>"
		        + "<place/>" + "<possibly_sensitive>false</possibly_sensitive>"
		        + "<contributors/>" + "</status>" + "</user>";

		TwitterParser parser = new TwitterParser();

		User user = parser.getUser(xmlData);
		System.out.println(user);
		assertEquals("122119770", user.getSocialId());
		assertEquals("Artur", user.getFirstName());
		assertEquals("", user.getLastName());
		assertEquals(null, user.getTitle());
		*/
	}
}
