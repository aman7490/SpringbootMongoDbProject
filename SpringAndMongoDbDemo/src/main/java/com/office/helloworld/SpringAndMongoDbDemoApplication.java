package com.office.helloworld;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

import org.springframework.context.annotation.Bean;

/**
 * @author amandeep.singh
 *
 */
//combination of @configuration + @component scan + @Enable autoconfiguration annotations.
@SpringBootApplication   
public class SpringAndMongoDbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAndMongoDbDemoApplication.class, args);
	}
/*@Bean
public ServletWebServerFactory servletContainer() {
	
	TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() 

	{
		@Override
		protected void postProcessContext(Context context) {
			// TODO Auto-generated method stub
			//super.postProcessContext(context);
			SecurityConstraint securityConstraint = new SecurityConstraint();
			securityConstraint.setUserConstraint("CONFIDENTIAL");
			SecurityCollection collection = new SecurityCollection();
			collection.addPattern("/*");
			securityConstraint.addCollection(collection);
			context.addConstraint(securityConstraint);
		}
	};
	
	tomcat.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());
	
	return tomcat;
	
}
	

private Connector httpToHttpsRedirectConnector() {
	Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
	connector.setScheme("http");
	connector.setPort(8080);
	connector.setSecure(false);
	connector.setRedirectPort(443);
	return connector;
}
*/
	
}
