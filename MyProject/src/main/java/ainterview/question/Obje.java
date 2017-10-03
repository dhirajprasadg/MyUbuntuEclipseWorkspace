package ainterview.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Obje {
	/*
	 * what are default method in object class 1 HashCode 2 equal 3 wait 4 wait
	 * 5 wait 6 notify 7 notifyAll 8 Clone 9 finalize 10 toString 11 newInstance
	 * 
	 * How to handel complie time exception What is wrapper Class and why it is
	 * used
	 */

	public static void main(String[] args) {
		Object ob = new Object();
		int num = checktry();
		System.out.println(" Vallue of numb : " + num);
		String st = "dd";
		String st2 = new String("dd");
		if (st.equals(st2)) {
			System.out.println(" Reference equal stst2 : " + st == st2);
			String sta[] = new String[3];
			// System.out.println(" Array size: " + sta.length);
			sta[0] = st;
			sta[1] = st2;
			sta[2] = "afsd";
			for (String staa : sta) {
				// System.out.println(" Array contain : " + staa );
			}
			List lis = Arrays.asList(sta);
			// System.out.println(" List size : " + lis.size());
			// System.out.println(" get element : " + lis.get(0));
			List<String> li = new ArrayList<>();
			li.add("aad");
			System.out.println(" Array List use add and get method : " + li.get(0));
			List<String> link = new LinkedList<>();
			link.add("fdas");
			System.out.println(" Linked List use add and get method : " + link.get(0));
            Set<String> se = new HashSet<>();
            se.add("ad");
            System.out.println(" HashSet use add however to get element use Iterator or for loop : " );
			for(String hse: se){
				System.out.println(" Element in HashSet : " + hse);
			}
            Map<String, String> ma = new HashMap<>();
			ma.put("key", "value");
			System.out.println(" Hash Map use put and get : " + ma.get("key"));

		} else {
			System.out.println(" reference not equal");
		}

	}

	private static int checktry() {
		try {
			System.out.println(" Inside the try block");
			// int i = 4 / 0;
			return 4;
		} catch (Exception e) {

			// System.out.println(" Inside the catch block ");
			// e.printStackTrace();
			return 55;
		} finally {
			// System.out.println(" Inside the finally Block");
			return 33;
		}
		// return 22;
	}
}

/*
 * Object ob = new Object(); Class cl = ob.getClass();
 * System.out.println(" get class name of object : " + cl.getName()); String st
 * = "abc"; if (st.equals("ee")) { System.out.println(" String are equal "); }
 * else { System.out.println(" string are not equal "); }
 */