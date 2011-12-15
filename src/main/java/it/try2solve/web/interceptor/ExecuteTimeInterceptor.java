package it.try2solve.web.interceptor;

import it.try2solve.web.debug.DebugContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.ModelAndView;


public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {

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

		if(modelAndView == null) {
			return;
		}
		
		DebugContext.put("endTime", System.currentTimeMillis());
		DebugContext.put("duration", Long.valueOf(DebugContext.get("endTime")) - Long.valueOf(DebugContext.get("startTime")));
	}
}
