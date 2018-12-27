package com.dragon.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dragon.demo.config.AppConfig;
import com.dragon.demo.controller.DemoController;

public class AppContextStarter {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext();
		acac.register(AppConfig.class);
		
		acac.scan("com.dragon.demo");
		acac.refresh();
		DemoController demoController = acac.getBean(DemoController.class);
		System.out.println(demoController);
		acac.close();
		
		

	}

}
