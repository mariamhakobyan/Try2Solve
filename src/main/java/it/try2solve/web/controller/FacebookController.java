package it.try2solve.web.controller;


import it.try2solve.data.model.User;
import it.try2solve.oauth.OAuthServiceProvider;
import it.try2solve.oauth.parser.FacebookParser;
import it.try2solve.service.Service;
import it.try2solve.util.StringUtils;

import org.scribe.model.*;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static it.try2solve.web.SessionAttributes.*;
import static org.springframework.web.context.request.RequestAttributes.*;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FacebookController {
	
	@Autowired
	@Qualifier("facebookServiceProvider")
	private OAuthServiceProvider facebookServiceProvider;
	
	@Autowired
	@Qualifier("userService")
	Service userService;
	
	private static final Token EMPTY_TOKEN = null;
	
	@RequestMapping(value={"/login-facebook"}, method = RequestMethod.GET)
	public String login(WebRequest request) {
		
		// getting request and access token from session
		Token accessToken = (Token) request.getAttribute(ATTR_OAUTH_ACCESS_TOKEN, SCOPE_SESSION);
		if(accessToken == null) {
			// generate new request token
			OAuthService service = facebookServiceProvider.getService();
			request.setAttribute(ATTR_OAUTH_REQUEST_TOKEN, EMPTY_TOKEN, SCOPE_SESSION);
			
			// redirect to facebook auth page
			return "redirect:" + service.getAuthorizationUrl(EMPTY_TOKEN);
		}
		return "welcomePage";
	}
	
	@RequestMapping(value={"/facebook-callback"}, method = RequestMethod.GET)
	public ModelAndView callback(@RequestParam(value="code", required=false) String oauthVerifier, WebRequest request) {
		
		// getting request token
		OAuthService service = facebookServiceProvider.getService();
		Token requestToken = (Token) request.getAttribute(ATTR_OAUTH_REQUEST_TOKEN, SCOPE_SESSION);
		
		// getting access token
		Verifier verifier = new Verifier(oauthVerifier);
		Token accessToken = service.getAccessToken(requestToken, verifier);
		
		// store access token as a session attribute
		request.setAttribute(ATTR_OAUTH_ACCESS_TOKEN, accessToken, SCOPE_SESSION);
		
		// getting user profile
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, "https://graph.facebook.com/me");
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();

		String responseBody = oauthResponse.getBody();
		if(StringUtils.isNotBlank(responseBody)) {
			FacebookParser parser = new FacebookParser();
			User user = parser.getUser(responseBody);
			userService.save(user);
			request.setAttribute(ATTR_LOGGED_IN_USER, user, SCOPE_SESSION);
		}

		ModelAndView mav = new ModelAndView("redirect:welcome");
		return mav;
	}
}