package com.vogella.jersey.first;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello {

	public Hello(){
		System.out.println(" Hello Class Default Constructor invoked ");
	}
	
  // This method is called if TEXT_PLAIN is request
	// changes to test in git
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() {
	  System.out.println(" say Plain Text Hello ");
    return "Hello Jersey";
  }

  // This method is called if XML is request
  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello() {
	  System.out.println(" Say XML Hello ");
    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
  }

  // This method is called if HTML is request
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello() {
	  System.out.println(" Say HTML Hello ");
    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
  }
  Object obj = new Object();
  
}