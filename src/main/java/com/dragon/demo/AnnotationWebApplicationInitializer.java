package com.dragon.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.dragon.demo.config.AppConfig;
import com.dragon.demo.controller.AnnotationController;

public class AnnotationWebApplicationInitializer implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("AnnotationWebApplicationInitializer...");
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(AppConfig.class);
		appContext.scan("com.dragon.demo.*");
		appContext.refresh();
		
		System.out.println("annotationController=" + appContext.getBean(AnnotationController.class));
		
		servletContext.addListener(new ContextLoaderListener(appContext));
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);
 
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
		dispatcher.addMapping("*.do");
		dispatcher.setLoadOnStartup(1);
	}

}
