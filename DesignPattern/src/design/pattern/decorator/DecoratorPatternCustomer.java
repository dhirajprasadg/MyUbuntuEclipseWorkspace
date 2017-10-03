package design.pattern.decorator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DecoratorPatternCustomer {
	private static int choice;

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.println(" Food Menu ");
		System.out.println(" 1 - Chineese Food ");
		InputStream im = System.in;
		InputStreamReader ire = new InputStreamReader(im);
		BufferedReader br = new BufferedReader(ire);
//		System.out.println(" Input inserted : " + br.readLine());
		choice = Integer.parseInt(br.readLine());
	//	System.out.println(" Input : " + choice);

		switch(choice){
		case 1 :{
			System.out.println( " Preparing Chineese Food ");
			Food fd = new ChineeseFood(new VegFood() );
			System.out.println( " Food : " + fd.prepareFood());
			System.out.println(" Food Price : " + fd.foodPrice());
			
		}break;
		case 2: {
			
		}break;
		default:{
			System.out.println( "  Food is not available");
		}
		
		}
		
		
	}

}
