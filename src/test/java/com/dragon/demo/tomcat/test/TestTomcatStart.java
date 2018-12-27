package com.dragon.demo.tomcat.test;

import java.util.Properties;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.junit.Test;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

public class TestTomcatStart {
	/**
	 * 
	 * Start a tomcat instance and simulate a request from browser,
	 * also get response to show in the page.
	 * 
	 * 
	 * @throws LifecycleException
	 */
	@Test
	public void test01() throws LifecycleException {
		Tomcat tomcat = new Tomcat();
		tomcat.setBaseDir("D:\\workspace\\tomcat-demo\\tomcat.8080");
		tomcat.setPort(8080);
		String webappPath = "D:\\workspace\\tomcat-demo\\src\\main\\webapp";
		Context context = tomcat.addWebapp("/zhu", webappPath);
		System.out.println("context=" + context);
		Service service = tomcat.getService();
		Connector connector = new Connector();
		connector.setPort(8080);
		System.out.println("connector=" + connector);
		service.addConnector(connector);
		tomcat.start();
		tomcat.getServer().await();
	}
	/**
	 * 
	 * This is for AnnotationWebApplicationInitializer test
	 * 
	 * @throws LifecycleException
	 */
	@Test
	public void test02() throws LifecycleException {
		Tomcat tomcat = new Tomcat();
		tomcat.setBaseDir("D:\\workspace\\tomcat-demo\\tomcat.8080");
		tomcat.setPort(8080);
		String webappPath = "D:\\workspace\\tomcat-demo\\src\\main\\webapp";
		Context context = tomcat.addWebapp("/zhu", webappPath);
		System.out.println("context=" + context);
		Service service = tomcat.getService();
		Connector connector = new Connector();
		connector.setPort(8080);
		System.out.println("connector=" + connector);
		service.addConnector(connector);
		tomcat.start();
		tomcat.getServer().await();
		
	}

}