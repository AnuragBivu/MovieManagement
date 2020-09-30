package com.cg.moviemanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggerInterceptor implements HandlerInterceptor{
	
	Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse arg1, Object obj, Exception arg3)
			throws Exception {
		HandlerMethod mtd =(HandlerMethod)obj;
		
		logger.debug( "after procesing jsp and sending the Response  to the browser for the URI " + req.getRequestURI());
	}

	@Override
	public void postHandle(HttpServletRequest req, 	HttpServletResponse arg1, Object obj, ModelAndView mv)
			throws Exception {
		HandlerMethod mtd =(HandlerMethod)obj;
		String str = mtd.getMethod().getName() + " method of " + mtd.getBean().getClass().getSimpleName() ;
		
		logger.debug(str + " is executed and forwarding  for the URI " + req.getRequestURI());
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse arg1, Object obj) throws Exception {
		HandlerMethod mtd =(HandlerMethod)obj;
		String str = mtd.getMethod().getName() + " method of " + mtd.getBean().getClass().getSimpleName() ;
		logger.debug("It is invoking the " + str + "for the URI " +req.getRequestURI());
		return true;
	}

}

