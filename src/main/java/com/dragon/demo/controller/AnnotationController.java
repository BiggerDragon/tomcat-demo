package com.dragon.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnotationController{
	
	@RequestMapping("/anno.do")
	String hello() {
		return "hello annotation controller!";
	}

}
