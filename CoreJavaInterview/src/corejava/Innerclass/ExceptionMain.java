package corejava.Innerclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExceptionMain {

	public static void main(String[] args) {

		try{
			int a = 1/0;
		}catch(ArithmeticException e){
			e.printStackTrace();
			System.out.println(" Exception catch ");
		}catch(Exception e){
			System.out.println(" 2nd Catch ");
		}
		Map<String,String> ma = new HashMap<>();
		ma.put("1", "Cart");
		ma.put("2", "Cart1");
		ma.put("3", "Cart2");
		
		System.out.println("Cart : " + ma.get("1"));
		
		Set<String> se = ma.keySet();
		System.out.println(" Key SEt : " + se);
		
		Iterator it = se.iterator();
		while(it.hasNext()){
			String key = (String) it.next();
			System.out.println(" Value are : " + ma.get(key));
		//	System.out.println(" Iterate throught : " + it.next());
		}
		
		// List<User> us = Arrays.asList(new User(1, "Dhiraj"), new User(1,
		// "Dhiraj"));
		List<User> us = new ArrayList<User>();
		us.add(new User(2, "Dhiraj"));
		us.add(new User(1, "Ahiraj"));
		us.add(new User(1, "Chiraj"));
		
		us.sort(new Comparator<User>(){

			@Override
			public int compare(User o1, User o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
			
		});
		
		Iterator s = us.iterator();
		while (s.hasNext()) {
			System.out.println(s.next());
		}

		System.out.println("============================");
		for (User use : us) {
			System.out.println(" Users are : " + use.toString());
		}

		System.out.println(" User 1 : " + us.get(0).toString());
		System.out.println(" User 2 : " + us.get(1).toString());

	}

}
