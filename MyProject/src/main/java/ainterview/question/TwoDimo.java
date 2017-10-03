package ainterview.question;

import java.util.Scanner;

public class TwoDimo {

	public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);
		  System.out.println("Enter the square size");
		  //char ch = sc.next().charAt(0);
		 int k = sc.nextInt();
		 int nu = 1;
		for (int j = 1; j <= k; j++) {

			for (int i = 1; i <= k; i++) {
				System.out.print(" " + nu + " ");
				nu++;
			}
			System.out.println(" ");
		}

	}

}
