package com.dragon.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dragon.demo.servlet.DemoServlet;

public class ClassPathAppContextStarter {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext cxac = new ClassPathXmlApplicationContext();
		cxac.setConfigLocation("classpath:applicationContext.xml");
		cxac.refresh();
		DemoServlet demoServlet = cxac.getBean(DemoServlet.class);
		System.out.println(demoServlet);
		cxac.close();
	}

}
