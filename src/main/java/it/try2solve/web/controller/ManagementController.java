package it.try2solve.web.controller;


import it.try2solve.data.model.Role;
import it.try2solve.web.annotation.RolesAllowed;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagementController {
	
	@RequestMapping(value={"/admin/management"}, method = RequestMethod.GET)
	@RolesAllowed( { Role.ADMIN } )
	public ModelAndView welcome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("managementPage");
		return mav;
	}
}