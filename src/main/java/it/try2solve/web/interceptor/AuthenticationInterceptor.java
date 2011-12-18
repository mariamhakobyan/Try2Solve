package it.try2solve.web.interceptor;

import it.try2solve.data.model.Role;
import it.try2solve.web.ControllerMethodResolver;
import it.try2solve.web.annotation.RolesAllowed;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private ControllerMethodResolver controllerMethodResolver;

	@Override
	public boolean preHandle(HttpServletRequest request,
	        HttpServletResponse response, Object handler) throws Exception {
		
		// continue if method can't be resolved
		Method method = controllerMethodResolver.getControllerMethod(handler, request);
		if(method == null) {
			return true;
		}
		
		// if no RolesAllowed annotation continue
		RolesAllowed role = AnnotationUtils.getAnnotation(method, RolesAllowed.class);
		if(role == null) {
			return true;
		}
		
		// collect all annotation roles into set
		Set<Integer> roles = new HashSet<Integer>(role.value().length);
		for(int value : role.value()) {
			roles.add(value);
		}
		
		// if role contains admin value then check session
		if(roles.contains(Role.ADMIN)) {
			// if user is not logged in redirect to admin login page
			response.sendRedirect("");
			return false;
		} else if(roles.contains(Role.ORDINARY)) { // if role contains ordinary value then check session
			// if user is not logged in redirect to basic login page
			response.sendRedirect("");
			return false;
		}
	
		return true;
	}

}
