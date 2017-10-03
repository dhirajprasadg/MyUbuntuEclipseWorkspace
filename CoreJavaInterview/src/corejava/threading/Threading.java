package corejava.threading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Threading {

	public static void main(String[] args) {
        Employee e1 = new Employee(1, "Ehiraj", "tcs");
        Employee e2 = new Employee(1, "Dhiraj", "tcs");
		// default equal of object compare the reference
        if(e1.equals(e2)){
        	System.out.println(" boht are equal ");
        }else{
        	System.out.println(" both are not equla ");
        }
       
        if(e1==e2){
        	System.out.println(" boht are equal ");
        }else{
        	System.out.println(" both are not equla ");
        }
        System.out.println("=================");
        
         String a = "dk";
        // String b = "dk";
         String b = new String("dk");
        
        if(a.equals(b)){
        	System.out.println(" boht are equal ");
        }else{
        	System.out.println(" both are not equla ");
        }
        if(a==b){
        	System.out.println(" boht are equal ");
        }else{
        	System.out.println(" both are not equla ");
        }
        
        
	    List<Employee> lis = new ArrayList<Employee>();
	    lis.add(e1);
		lis.add(e2);
	    Collections.sort(lis , new Comparator<Employee>(){
			@Override
			public int compare(Employee o1, Employee o2) {

			    return o1.getName().compareTo(o2.getName());	
			
			}
	    });
	    
	    Iterator<Employee> its = lis.iterator();
		while (its.hasNext()) {
			System.out.println(" Printing Iterator List " + its.next().getName());
			
		}
	
	    
	    Set<Employee> li = new HashSet<Employee>();
		li.add(e1);
		li.add(e2);
	
		System.out.println("=============Position1========");
		
		if(li.contains(new Employee(1, "Dhiraj", "tcs"))){
			System.out.println(" Emp 1 is true ");
		}else{
			System.out.println(" Emp 1 is not there");
		}
		
	
		System.out.println("=============Position1========");	
	
		Iterator<Employee> it = li.iterator();
		while (it.hasNext()) {
			System.out.println(" Printing Iterator " + it.next());
			
		}
	
	}

}
