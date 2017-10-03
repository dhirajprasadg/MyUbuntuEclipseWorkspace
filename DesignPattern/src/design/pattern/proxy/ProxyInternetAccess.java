package design.pattern.proxy;

public class ProxyInternetAccess implements OfficeInternetAccess{
	
	public String employee;
	public RealInternetAccess realaccess;
	
	public ProxyInternetAccess(String ename){
		this.employee=ename;
	}
	
	@Override
	public void grantInternetAccess() { 
	   if(getRole(employee) > 4){
		   realaccess = new RealInternetAccess(employee);
		   realaccess.grantInternetAccess();
		   
	   }else{
		   System.out.println(" dont have access to ");
	   }		
		
	}

	private int getRole(String employee2) {		
		return 7;
	}
		
}
