package design.pattern.proxy;

public class RealInternetAccess  {
	
	public String employee;
	
	public RealInternetAccess(String emp){
		this.employee=emp;
	}
	
	
	public void grantInternetAccess() {
      System.out.println(" Internet Access granted to employee : " + employee);
	}

}
