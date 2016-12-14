package cn.itsource.springmvc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Hello2Controller implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("show","你好hello2");
		modelAndView.setViewName("/hello2.jsp");

		return modelAndView;
	}

}
