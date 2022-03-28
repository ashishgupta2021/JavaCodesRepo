package com.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// No root config class only servlet config class
	@Override
	protected Class<?>[] getRootConfigClasses() {
 		return null;
	}

	// Servlet Config class 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	// <servlet-mapping>
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
