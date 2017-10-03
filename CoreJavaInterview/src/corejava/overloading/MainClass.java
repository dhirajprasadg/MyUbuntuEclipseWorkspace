package corejava.overloading;

import java.lang.reflect.Method;

public class MainClass {

	public static void main(String[] args) {
		Payment pa = new Payment("ddd");
		try {
			Payment pp = (Payment) pa.clone();
			System.out.println(" Payment cloned object : " + pp.toString());
			if(pa==pp){
				System.out.println(" cloned object is eqaul in reference ");
			}else if(pa.equals(pp)) {
				System.out.println( " both object are equal " );
			} else{
				System.out.println(" Not equal ");
			}
			
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		Method[] me = pa.getClass().getMethods();
		for(int i =0;i <me.length;i++){
			System.out.println(" Payment Method Name : " + me[i].getName() );		
		}
		System.out.println("=============================");	
		Object oa = new Object();
		Method[] oaa = oa.getClass().getMethods();
		for(int i =0;i <oaa.length;i++){
		//	System.out.println(" Payment Method Name : " + oaa[i].getName() );		
		}
	
	
	}

}
