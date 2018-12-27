package com.dragon.demo;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class DragonWebApplicationInitializer implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("DragonWebApplicationInitializer...onStartup()...");
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		appContext.setConfigLocation("classpath:META-INF/applicationContext.xml");
		
		XmlWebApplicationContext dispatcherContext = new XmlWebApplicationContext();
		dispatcherContext.setConfigLocation("classpath:META-INF/dispatcherServlet-servlet.xml");
		appContext.refresh();
		dispatcherContext.setParent(appContext);
		DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
		dispatcherContext.refresh();
		ServletRegistration.Dynamic dispatcher 
			= servletContext.addServlet("dispacther", dispatcherServlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("*.do");
		
		
	}

}
