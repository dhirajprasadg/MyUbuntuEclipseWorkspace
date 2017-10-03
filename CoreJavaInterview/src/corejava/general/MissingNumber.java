package corejava.general;

import java.util.Arrays;

public class MissingNumber {
	public static void main(String[] args) {
		int[] num = { 1, 2 };

		getMissingNumber(num);
		getHighestNumberbyShorting(num);
	}

	private static void getHighestNumberbyShorting(int[] num) {
		Arrays.sort(num);
		System.out.println(" Higest Number : " + (num[num.length-1]));
		
	}

	private static void getMissingNumber(int[] num) {
      int lengthofarray = num.length+1;
      int sumofnumber =0;
      for(int nu : num){
    	  sumofnumber = sumofnumber + nu;
      }
	  System.out.println(" Sum of number in arrar : " + sumofnumber);

	  int sum = (lengthofarray*(lengthofarray+1)) /2;
	  System.out.println(" Sum " + sum);
	  int missingnum = sum -sumofnumber;
	System.out.println("  Missing Number :" + missingnum);
	}

}
