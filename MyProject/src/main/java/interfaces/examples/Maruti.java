package interfaces.examples;

public class Maruti extends VehicleFunctionality implements CarModel{

	public String typeofCarModel() {
		int sp = speed();
		return "Maruti " + sp;
	}

	public static void main(String[] args) {
		Vehicle v = new Maruti();
		System.out.println(v.speed());
		CarModel mar = new Maruti();
        System.out.println(mar.speed());
        System.out.println(mar.typeofCarModel());
		
		
		
	}
}
