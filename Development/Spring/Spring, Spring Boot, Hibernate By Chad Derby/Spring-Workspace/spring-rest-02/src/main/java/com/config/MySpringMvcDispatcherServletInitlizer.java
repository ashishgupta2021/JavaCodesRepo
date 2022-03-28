package com.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitlizer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("MySpringMvcDispatcherServletInitlizer.getServletConfigClasses()");
		return new Class[] { AppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("MySpringMvcDispatcherServletInitlizer.getServletMappings()");
		// Maps to Root Path
		return new String[] { "/" };
	}

}
