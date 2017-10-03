package corejava.Innerclass;

public class Executive {
	private String FirstName = "Dhiraj";
	String MiddleName = "Prasad";
	protected String LastName = "Bhagat";

	public void exectutive(){
		System.out.println(" executinve method called from Executive class");
	}
	public String getName(){
		return FirstName + MiddleName + LastName ;
	}
	
	private String getNamep(){
		return FirstName + MiddleName + LastName ;
	}

	
	
}
