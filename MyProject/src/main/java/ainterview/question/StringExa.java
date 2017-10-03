package ainterview.question;

import java.util.ArrayList;
import java.util.List;

public class StringExa {

	public static void main(String[] args) {

		Fruits ft = new Fruits();
		Fruits ft1 = new Fruits();
		System.out.println(" No of Fruit Object : " + Fruits.counter);
		
	}

	static class Fruits {
        static int counter;
        public Fruits (){
        	counter++;
        }
		
	}

}

/*
 * int j = 3; int k = 3; for (int i = 0; i < 1; i++) {
 * System.out.println(" Value of J : " + ++j + " Value of K : " + k++);
 * System.out.println(" Value of J : " + j + " Value of K : " + k);
 * System.out.println("---------------------"); }
 * 
 * Boolean m = true; Boolean n = true;
 * 
 * if (m | n) { System.out.println(" both are true"); } if (m & n) {
 * System.out.println(" m and n are true"); }else if (m && n) {
 * System.out.println(" m and n are true"); } else {
 * System.out.println(" Exception"); }
 * 
 * }
 * 
 * 
 * String s5 = "Prakash"; String s6 = new String("Prakash"); List<String> ls =
 * new ArrayList<String>(); ls.add(s5); ls.add(s6);
 * 
 * if (s5 == s6) { System.out.println(" reference are equal" + ls.size()); }
 * else { System.out.println(" reference is not equal " + ls.size());
 * System.out.println(s5); System.out.println(s6); } System.gc(); if (s5 == s6)
 * { System.out.println(" reference are equal" + ls.size()); } else {
 * System.out.println(" reference is not equal " + ls.size());
 * System.out.println(s5); System.out.println(s6); }
 * 
 * 
 * 
 * String st = "Dhiraj"; st.toUpperCase();
 * System.out.println(" String in uppercase : " + st); String st1 =
 * st.toUpperCase(); System.out.println(" String in uppercase : " + st1);
 * 
 * String s3 = "Prakash"; String s4 = s3.substring(4, 6);
 * System.out.println(" Substring S4 : " + s4);
 * 
 * 
 */
