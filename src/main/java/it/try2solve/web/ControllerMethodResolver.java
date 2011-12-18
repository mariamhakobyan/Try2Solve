package it.try2solve.web;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

public class ControllerMethodResolver {

	@Autowired
	private AnnotationMethodHandlerAdapter handlerAdapter;

	public Method getControllerMethod(Object handler, HttpServletRequest request) {
		Map methodResolverCache = getMethodResolverCache();
		if (methodResolverCache == null) {
			return null;
		}
		
		Object methodResolver = methodResolverCache.get(handler.getClass().getSuperclass());
		if (methodResolver == null) {
			methodResolver = methodResolverCache.get(handler.getClass());
			if (methodResolver == null) {
				return null;
			}
		}
		Method method = getMethod(methodResolver, request);
		return method;
	}

	public Annotation getAnnotationFromControllerMethod(Object handler,
	        HttpServletRequest request, Class annotationClass) {
		Method method = getControllerMethod(handler, request);
		if (method == null) {
			return null;
		}
		Annotation annotation = method.getAnnotation(annotationClass);
		return annotation;
	}

	private Method getMethod(Object methodResolver, HttpServletRequest request) {
		Method method = null;
		try {
			Method methodMethod = methodResolver.getClass().getDeclaredMethod(
			        "resolveHandlerMethod", HttpServletRequest.class);
			ReflectionUtils.makeAccessible(methodMethod);
			method = (Method) methodMethod.invoke(methodResolver, request);
		} catch (Exception e) {
		}
		return method;
	}

	private Map getMethodResolverCache() {
		Map cache = null;
		try {
			Field methodCacheField = handlerAdapter.getClass()
			        .getDeclaredField("methodResolverCache");
			ReflectionUtils.makeAccessible(methodCacheField);
			cache = (Map) methodCacheField.get(handlerAdapter);
		} catch (Exception e) {
		}
		return cache;
	}

}
