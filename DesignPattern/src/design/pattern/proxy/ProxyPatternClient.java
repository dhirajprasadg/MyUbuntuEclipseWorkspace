package design.pattern.proxy;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class ProxyPatternClient {

	public static void main(String[] args) {

		OfficeInternetAccess iacc = new ProxyInternetAccess("Rama");
		iacc.grantInternetAccess();
		
	/*	OfficeInternetAccess ac = new RealInternetAccess("dd");
		    ac.grantInternetAccess();*/
	    
	}
	

}
