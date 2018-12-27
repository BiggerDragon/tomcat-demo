package com.dragon.demo;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import org.apache.catalina.Host;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Service;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.WebResourceSet;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.EmptyResourceSet;
import org.apache.catalina.webresources.StandardRoot;

/**
 * 
 * @author Administrator
 *
 */
public class TomcatStarter {

	public static File getRootFolder() {
		try {
			File root;
			String runningJarPath = TomcatStarter.class.getProtectionDomain().getCodeSource().getLocation().toURI()
					.getPath().replaceAll("\\\\", "/");
			int lastIndexOf = runningJarPath.lastIndexOf("/target/");
			if (lastIndexOf < 0) {
				root = new File("");
			} else {
				root = new File(runningJarPath.substring(0, lastIndexOf));
			}
			System.out.println("application resolved root folder: " + root.getAbsolutePath());
			return root;
		} catch (URISyntaxException ex) {
			throw new RuntimeException(ex);
		}
	}

	public static void main(String[] args) throws LifecycleException, IOException {
		File root = getRootFolder();
		System.out.println(root.getAbsolutePath());
//		System.setProperty("org.apache.catalina.startup.EXIT_ON_INIT_FAILURE", "true");
		Path temDir = Files.createTempDirectory("tomcat-base-dir");
		System.out.println(temDir);
		Tomcat tomcat = new Tomcat();
		tomcat.setBaseDir(temDir.toString());
		String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
        System.out.println(webPort);
        tomcat.setPort(Integer.valueOf(webPort));
        tomcat.setHostname("localhost");
        File webContentFolder = new File(root.getAbsolutePath(), "src/main/webapp/");
        if(!webContentFolder.exists()) {
        	webContentFolder = Files.createTempDirectory("default-doc-base").toFile();
        }
        
        StandardContext ctx = (StandardContext)tomcat.addWebapp("/zhu", webContentFolder.getAbsolutePath());
      /**
       * 
       * The following commented code is not necessary!
       * 
       */
//        ctx.setParentClassLoader(TomcatStarter.class.getClassLoader());
//        System.out.println("configuring app with basedir: " + webContentFolder.getAbsolutePath());
        
        // Declare an alternative location for your "WEB-INF/classes" dir
        // Servlet 3.0 annotation will work
//        File additionWebInfClassesFolder = new File(root.getAbsolutePath(), "target/classes");
//        WebResourceRoot resources = new StandardRoot(ctx);
//        
//        WebResourceSet resourceSet;
//        if (additionWebInfClassesFolder.exists()) {
//            resourceSet = new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClassesFolder.getAbsolutePath(), "/");
//            System.out.println("loading WEB-INF resources from as '" + additionWebInfClassesFolder.getAbsolutePath() + "'");
//        } else {
//            resourceSet = new EmptyResourceSet(resources);
//        }
//        resources.addPreResources(resourceSet);
//        ctx.setResources(resources);

        tomcat.start();
        
        Host host = tomcat.getHost();
        
        Service service = tomcat.getService();
        
        /**
         * The connector must be created! I failed to access the server many times by inputing
         * localhost:8080 or 127.0.0.1:8080 on my Chrome browser. Eventually I added the connector 
         * to the service! Connector is responsible for resolving client connections! Detail information 
         * please check doc of Connector class.
         */
        Connector connector = new Connector();
        connector.setPort(8080);
        
        service.addConnector(connector);
        Connector[] connectors = service.findConnectors();
        System.out.println("connectors=" + Arrays.toString(connectors));
        tomcat.getServer().await();
	}

}
