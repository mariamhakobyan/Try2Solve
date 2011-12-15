package it.try2solve.oauth.parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class OauthParser {

	protected SAXParser getSAXParser() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
	    SAXParser saxParser = null;
        try {
	        saxParser = factory.newSAXParser();
        } catch(Exception e) {
	        // TODO log
	        e.printStackTrace();
        }
	    return saxParser;
	    
	}
	
}
