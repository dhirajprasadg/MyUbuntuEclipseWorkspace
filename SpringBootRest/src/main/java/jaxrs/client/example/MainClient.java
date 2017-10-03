package jaxrs.client.example;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class MainClient {

	public static void main(String[] args) {
		
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("https://jsonplaceholder.typicode.com/posts/1");	
		Invocation.Builder request = target.request();
		
		Response response = request.get();
		
	    Object entity = response.getEntity();
	    
	    System.out.println( entity.toString());
	       
	}
	
}
