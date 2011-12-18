package it.try2solve.web.interceptor;

import it.try2solve.web.ControllerMethodResolver;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private ControllerMethodResolver controllerMethodResolver;

	@Override
	public boolean preHandle(HttpServletRequest request,
	        HttpServletResponse response, Object handler) throws Exception {
		
		//Controller controller = AnnotationUtils.findAnnotation(handler.getClass(), Controller.class);
		
		Method method = controllerMethodResolver.getControllerMethod(handler, request);
		System.out.println(method.getName());
	
		return true;
	}

}
