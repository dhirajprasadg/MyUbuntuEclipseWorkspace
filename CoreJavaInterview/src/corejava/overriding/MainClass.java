package corejava.overriding;

import java.io.IOException;

class Vehicles {

	public String getName() throws IOException, Exception {
		String name = null;
		return name.toString();
	}

}

class Cars extends Vehicles {

	@Override
	public String getName() throws Exception {
		String name = null;

		int i = 4;
		int j = 0;
		try {
			int k = i / j;
			System.out.println(" Exception ca");
			String n = name.toString();
			System.out.println(" Exception caa");
		} catch (NullPointerException e) {
			throw new NullPointerException();
		} catch (RuntimeException n) {
			// throw new RuntimeException();
		}
		System.out.println(" Exception caaaa");

		if (i < 2) {
			throw new Exception();
		}
		return "dd";
	}
}

public class MainClass {

	public static void main(String[] args) throws Exception {
		// Vehicle vc = new Vehicle();
		Vehicles vc = new Cars();
		vc.getName();
		try {
			String na = null;
			na.toString();
		} catch (RuntimeException r) {
			System.out.println(" runtime exception");

		}

	}
}
