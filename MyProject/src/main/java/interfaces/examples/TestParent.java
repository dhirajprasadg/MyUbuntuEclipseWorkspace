package interfaces.examples;

public class TestParent {

	protected TestParent(){
		System.out.println(" TestParent Constructor");
	}
	
	
	public static void main(String[] args) {
		TestParent tp = new Child();
		Integer in = null;
		Integer inS = null ;
		System.out.println("dfds" + in + " .. " + inS);
		//System.out.println("dfds" + in.hashCode());
		try{			
			int inte = in;
			System.out.println("inte value " + inte);

		}catch(Exception e){
			System.out.println(e);
		}
				
		//int i1 = 1/0;
		//System.out.println(i1);
	//http://stackoverflow.com/questions/3350641/array-remove-duplicate-elements
	}
}

class Child extends TestParent{
	public Child(){
		super();
		System.out.println(" Child class constructor");
		
	}
	
	
	
	
	
}