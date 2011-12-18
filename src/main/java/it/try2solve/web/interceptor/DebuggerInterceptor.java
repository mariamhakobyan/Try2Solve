package it.try2solve.web.interceptor;

import it.try2solve.web.debug.DebugContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.ModelAndView;


public class DebuggerInterceptor extends HandlerInterceptorAdapter {

	// after the handler is executed
	public void postHandle(HttpServletRequest request,
	        HttpServletResponse response, Object handler,
	        ModelAndView modelAndView) throws Exception {
		
		Controller controller = AnnotationUtils.findAnnotation(handler.getClass(), Controller.class);
		if(controller == null) {
			return;
		}
		
		System.out.println("DebuggerInterceptor");
		modelAndView.addObject("debugData", DebugContext.getMap());
	}
}
