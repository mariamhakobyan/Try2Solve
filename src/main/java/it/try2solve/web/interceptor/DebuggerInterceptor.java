package it.try2solve.web.interceptor;

import it.try2solve.web.debug.DebugContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.ModelAndView;


public class DebuggerInterceptor extends HandlerInterceptorAdapter {

	// after the handler is executed
	public void postHandle(HttpServletRequest request,
	        HttpServletResponse response, Object handler,
	        ModelAndView modelAndView) throws Exception {
		if(modelAndView == null) {
			return;
		}
		System.out.println("DebuggerInterceptor");
		modelAndView.addObject("debugData", DebugContext.getMap());
	}
}
