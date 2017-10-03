package ainterview.question;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
//http://stackoverflow.com/questions/2307283/what-does-olog-n-mean-exactly
public class DuplicateArray {

	public static void main(String[] args) {
		// remove duplicate from array
		int[] num = { 2, 2, 1, 4, 5, 6, 9, 4, 6 };
		/*
		 * System.out.println("Number Array " + num); for(int nu:num){
		 * System.out.println("Number Array " + nu); } for(int
		 * i=0;i<num.length;i++){ System.out.println("Numbers in Array at " + i
		 * + "  " + num[i]); }
		 */
		Map<Integer, Integer> uni = new HashMap<>();

		for (int i = 0; i < num.length; i++) {
			System.out.println(" ---- For Loop Executed " + i + "th times-----------");
			if (uni.containsKey(num[i])) {
				int value = (int) ((Integer) uni.get(num[i]));
				value = value + 1;
				uni.put(num[i], value);
				System.out.println(" Present Key Set " + uni.keySet());
				System.out.println(" Present Value " + uni.get(num[i]));
				System.out.println(" value present " + num[i]);
			} else {
				System.out.println(" Key Set " + uni.keySet());
				System.out.println(" value Not present " + num[i]);
				uni.put(num[i], 1);
			}

		}
		System.out.println("==================Remove duplicate using set=========");
		Set<Integer> se = new LinkedHashSet<>();
		for (int nu : num) {
			se.add(nu);
		}
		// System.out.println(" Set Value" + se.toArray());
		Object[] un = se.toArray();

		for (Object unk : un) {
			System.out.println(" Unique number " + unk);
		}

		int[] ar = {2,4,4,5,1};
		StringBuffer sf = new StringBuffer();
		for(int arr:ar)
		sf.append(arr);
		System.out.println("Array " + sf);
		List<Integer> li = new LinkedList<>();
		li.add(4);
		li.add(5);
		li.add(3);
		li.add(4);
		System.out.println(" Linked List " + li);
		
		
	}

}
