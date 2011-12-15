package it.try2solve.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import static it.try2solve.web.SessionAttributes.*;
import static org.springframework.web.context.request.RequestAttributes.*;

@Controller
public class LoginController {
	
	@RequestMapping(value={"/signin", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(WebRequest request) {
		if(request.getAttribute(ATTR_LOGGED_IN_USER, SCOPE_SESSION) != null) {
			ModelAndView mav = new ModelAndView("redirect:welcome");
			return mav;
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginPage");
		return mav;
	}
	
	@RequestMapping(value={"/signout", "/logout"}, method = RequestMethod.GET)
	public ModelAndView logout(WebRequest request) {
		
		request.removeAttribute(ATTR_LOGGED_IN_USER, SCOPE_SESSION);
		request.removeAttribute(ATTR_OAUTH_ACCESS_TOKEN, SCOPE_SESSION);
		request.removeAttribute(ATTR_OAUTH_REQUEST_TOKEN, SCOPE_SESSION);
		
		ModelAndView mav = new ModelAndView("redirect:welcome");
		return mav;
	}
}