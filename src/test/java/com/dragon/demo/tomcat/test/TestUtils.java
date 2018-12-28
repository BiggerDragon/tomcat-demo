package com.dragon.demo.tomcat.test;

import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import org.junit.Test;
import java.io.File;
import org.junit.Assert;

public class TestUtils {

	@Test
	public void test01() throws URISyntaxException {
		String path = TestUtils.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
		System.out.println(path);
		ProtectionDomain protectionDomain = TestUtils.class.getProtectionDomain();
		System.out.println("===========protectionDomain==========");
		System.out.println(protectionDomain);
		CodeSource codeSource = protectionDomain.getCodeSource();
		System.out.println("==========codeSource============");
		System.out.println(codeSource);
		URL location = codeSource.getLocation();
		System.out.println(location);
		System.out.println(location.toURI());
		System.out.println(location.toURI().getPath());
		
		File file = new File("./demo.txt");
		Assert.assertNotNull(file);



	}
	
}
