package it.try2solve.web.interceptor;

import java.lang.reflect.Method;

import it.try2solve.web.ControllerMethodResolver;
import it.try2solve.web.debug.DebugContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.ModelAndView;


public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private ControllerMethodResolver controllerMethodResolver;

	// before the actual handler will be executed
	public boolean preHandle(HttpServletRequest request,
	        HttpServletResponse response, Object handler) throws Exception {
		DebugContext.put("startTime", System.currentTimeMillis());
		System.out.println("ExecuteTimeInterceptor");
		return true;
	}

	// after the handler is executed
	public void postHandle(HttpServletRequest request,
	        HttpServletResponse response, Object handler,
	        ModelAndView modelAndView) throws Exception {

		Controller controller = AnnotationUtils.findAnnotation(handler.getClass(), Controller.class);
		if(controller == null) {
			return;
		}
		
		Method method = controllerMethodResolver.getControllerMethod(handler, request);
		if(method == null) {
			return;
		}
		
		DebugContext.put("duration(" + method.getDeclaringClass().getName() + "." + method.getName() + ")", System.currentTimeMillis() - Long.valueOf(DebugContext.get("startTime")));
		DebugContext.remove("startTime");
	}
	
}
