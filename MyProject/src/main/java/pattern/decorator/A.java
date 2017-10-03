package pattern.decorator;

import java.util.Arrays;

class A {

	static boolean exists(int[] ints, int k) {
	/*	for(int i : ints) 
		if(i==k) return true;
		return false;
*/	System.out.println(Arrays.binarySearch(ints, k) );
		return (Arrays.binarySearch(ints, k) > -1);

		/*
		boolean check = false;
		for (int i = 0; i < ints.length; i++) {
			System.out.println(" ints[i] " + ints[i] + " K vlaue " + k);
			if (ints[i] == k) {
				check =true;
			} else {
				check =false;
			}

		
		return check;
	*/
	}
/*
	public static void main(String[] args) {
		int[] ints = { -9, 14, 37, 102 };
		System.out.println(A.exists(ints, 102));
		System.out.println(A.exists(ints, -9));
		System.out.println(A.exists(ints, -4));
		System.out.println(A.exists(ints, 333));
	}
*/}

