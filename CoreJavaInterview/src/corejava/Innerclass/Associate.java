package corejava.Innerclass;

public class Associate extends Executive{
    private static String AssociateName = " Associate Dhiraj "; 
	
    
    public void nonstatic(){
		System.out.println(" non static method called ");
	}
   

	@Override
	public void exectutive() {
		System.out.println( " == executive method from associate ");
		super.exectutive();
	}

	public void outmethod(){
    	 InnerClass in = new InnerClass();
    	 in.innerclassmethod();
     }

     public static void staticmehtod(){
    	 System.out.println(" Static method called : " + AssociateName);
     }
	public class InnerClass{
	   public void innerclassmethod(){
		   System.out.println(" Innner class method called");
		  System.out.println(" Inner class accssing the out class method: " + getName());
	 
	   }
	}	
}
