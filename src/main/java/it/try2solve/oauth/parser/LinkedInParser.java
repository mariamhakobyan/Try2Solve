package it.try2solve.oauth.parser;

import it.try2solve.data.model.User;
import it.try2solve.data.model.UserSource;

import java.io.StringReader;
import java.util.Date;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class LinkedInParser extends OauthParser {

	public User getUser(String xmlData) {
		final User user = new User();
		user.setUserSource(UserSource.LinkedIn);
		user.setLastLogin((new Date()).getTime());
		
		DefaultHandler handler = new DefaultHandler() {
			
			private StringBuffer buffer;
			private String tagName;
			
			
			@Override
			public void startDocument() throws SAXException {
				buffer = new StringBuffer();
			}

			@Override
			public void characters(char[] ch, int start, int length)
			        throws SAXException {
				if (tagName.equals("first-name")) {
					buffer.append(new String(ch, start, length).trim());
				} else if (tagName.equals("last-name")) {
					buffer.append(new String(ch, start, length).trim());
				} else if (tagName.equals("id")) {
					buffer.append(new String(ch, start, length).trim());
				} else if(tagName.equals("headline")) {
					buffer.append(new String(ch, start, length).trim());
				}
			}

			@Override
			public void endElement(String uri, String localName, String qName)
			        throws SAXException {
				if (qName.equals("first-name")) {
					user.setFirstName(buffer.toString());
				} else if(qName.equals("last-name")){
					user.setLastName(buffer.toString());
				} else if(qName.equals("id")) {
					user.setSocialId(buffer.toString());
				} else if(qName.equals("headline")) {
					user.setTitle(buffer.toString());
				}
			}

			@Override
			public void startElement(String uri, String localName,
			        String qName, Attributes attributes) throws SAXException {
				buffer.setLength(0);
				tagName = qName;
			}

		};

		InputSource is = new InputSource(new StringReader(xmlData));
		is.setEncoding("UTF-8");

		try {
			getSAXParser().parse(is, handler);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

}
