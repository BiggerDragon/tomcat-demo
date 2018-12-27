package com.dragon.demo.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet{
	
	private static final long serialVersionUID = 5701117482475493759L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.getWriter().append("DemoServlet").close();
	}

	 

}
